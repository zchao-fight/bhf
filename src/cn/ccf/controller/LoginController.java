package cn.ccf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.constants.SessionConst;
import cn.ccf.forum.Service.PersonService;
import cn.ccf.forum.model.Person;
import cn.ccf.forum.util.PersonUtil;
import cn.ccf.mapper.RoleModuleMapper;
import cn.ccf.mapper.UserMapper;
import cn.ccf.mapper.UserRoleMapper;
import cn.ccf.mapper.VisitMapper;
import cn.ccf.pojo.RoleModule;
import cn.ccf.pojo.RoleModuleExample;
import cn.ccf.pojo.SessionUser;
import cn.ccf.pojo.User;
import cn.ccf.pojo.UserExample;
import cn.ccf.pojo.UserExample.Criteria;
import cn.ccf.pojo.Visit;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PersonService personService;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private RoleModuleMapper roleModuleMapper;
	
	@Autowired
	private VisitMapper visitMapper;

	/*
	 * @RequestMapping("/login") public String loginPage() { return "login"; }
	 */

	@RequestMapping("/handleLogin")
	public String handleLogin(HttpServletRequest req, String username,
			String password) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			req.setAttribute("loginMsg", "用户名密码为空");
			return "login";
		}

		UserExample ue = new UserExample();
		Criteria andNameEqualTo = ue.createCriteria().andNameEqualTo(username);
		// ue.or(andNameEqualTo);
		List<User> selectByExample = userMapper.selectByExample(ue);
		if (selectByExample == null || selectByExample.isEmpty()) {
			req.setAttribute("loginMsg", "用户名密码错误");
			return "login";
		}

		boolean succ = selectByExample.get(0).getPassword().equals(password);
		if (!succ) {
			req.setAttribute("loginMsg", "用户名密码错误");
			return "login";
		}
		SessionUser sessionUser = new SessionUser(selectByExample.get(0));
		sessionUser.setRole(selectByExample.get(0).getName()
				.equalsIgnoreCase("admin") ? SessionUser.ROLE_ADMIN
				: SessionUser.ROLE_COMMON);
		req.getSession().setAttribute(SessionConst.SESSION_USER, sessionUser);
		// req.getSession().setMaxInactiveInterval(30*60);
		return "redirect:/";
	}

	@RequestMapping("login")
	public String login(HttpServletRequest req, HttpServletResponse res,
			Integer id) {
		/*
		 * UserExample ue = new UserExample(); String name = ""; try { name =
		 * new String(username.getBytes("iso-8859-1"),"utf-8"); } catch
		 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } Criteria andNameEqualTo =
		 * ue.createCriteria().andNameEqualTo(name); //ue.or(andNameEqualTo);
		 * List<User> selectByExample = userMapper.selectByExample(ue);
		 * 
		 * SessionUser sessionUser = new SessionUser(selectByExample.get(0));
		 * req.getSession().setAttribute(SessionConst.SESSION_USER,
		 * sessionUser);
		 * 
		 * return "redirect:/";
		 */
		if (id == null) {
			return "login";
		}

		// 判断超级管理员
		if (id == -1) {
			User user = new User();
			SessionUser sessionUser = new SessionUser(user);
			// 超级管理员默认部门为联防中心
			sessionUser.setDepartmentID(1);
			sessionUser.setRole(SessionUser.ROLE_SUPER_ADMIN);
			req.getSession().setAttribute(SessionConst.SESSION_USER,
					sessionUser);

			saveCookie(sessionUser, null, res);

		} else {
			User user = userMapper.selectByPrimaryKey(id);
			SessionUser sessionUser = new SessionUser(user);
			
			//记录访问量
			Visit visit = new Visit();
			visit.setDepartmentid(user.getDepartmentid());
			visit.setUserid(user.getId());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			visit.setVisittime(df.format(new Date()));
			visit.setIp(req.getRemoteAddr());
			visitMapper.insert(visit);
			// 获取用户id
			int roleID = user.getRoleid();

			RoleModuleExample roleModuleExample = new RoleModuleExample();
			RoleModuleExample.Criteria roleCriteria = roleModuleExample
					.createCriteria();
			roleCriteria.andRoleidEqualTo(roleID);
			List<RoleModule> roleModules = roleModuleMapper
					.selectByExample(roleModuleExample);

			for (RoleModule roleModule : roleModules) {
				switch (roleModule.getModuleid()) {
				case 26673152:
					sessionUser.setDeleteThread(1);
					break;
				case 26411008:
					sessionUser.setOnAndCancel(1);
					break;
				case 26345472:
					sessionUser.setAddBoard(1);
					break;
				case 26279936:
					sessionUser.setAddCategory(1);
					break;
				case 25309184:
					sessionUser.setManageFilmCategory(1);
					break;
				case 25305088:
					sessionUser.setDeleteFilm(1);
					break;
				case 25300992:
					sessionUser.setUploadFilm(1);
					break;
				default:
					break;
				}
			}

			/*String roleName = userRoleMapper.selectByPrimaryKey(roleID)
					.getName();
			if (roleName.equals("管理员")) {
				sessionUser.setRole(SessionUser.ROLE_ADMIN);
			} else {
				sessionUser.setRole(SessionUser.ROLE_COMMON);
			}*/

			Person person = new Person();
			person.setAccount(user.getName());
			person.setPassword(user.getPassword());

			Person isPerson = personService.getPerson(person);

			if (isPerson == null) {
				person.setIpcreated(req.getRemoteAddr());
				person.setIplastactived(req.getRemoteAddr());
				person.setDatecreated(new Date());
				person.setDatelastactived(new Date());
				person.setDeleted(false);
				person.setName(user.getName());
				// person.setSex(user.getSex());
				personService.insert(person);
				PersonUtil.setPersonInf(req, res,
						personService.findPersonByAccount(person.getAccount()));

			} else {
				PersonUtil.setPersonInf(req, res, isPerson);
				isPerson.setIplastactived(req.getRemoteAddr());
				isPerson.setDatelastactived(new Date());
				personService.save(isPerson);
			}

			saveCookie(sessionUser, isPerson, res);

			req.getSession().setAttribute(SessionConst.SESSION_USER,
					sessionUser);
			req.getSession().setMaxInactiveInterval(3 * 60 * 60);
		}
		return "redirect:/";
	}

	private void saveCookie(SessionUser sessionUser, Person isPerson,
			HttpServletResponse res) {
		Map<String, Object> cookieData = new HashMap<>();
		cookieData.put("user", sessionUser.getUser());
		cookieData.put("role", sessionUser.getRole());
		cookieData.put("person", isPerson);
		String jsonString = JSONObject.toJSONString(cookieData);
		Cookie cookie = new Cookie(SessionConst.COOKIE_NAME,
				Base64.encodeBase64String(jsonString.getBytes()));
		cookie.setMaxAge(Integer.MAX_VALUE);
		cookie.setPath("/");
		res.addCookie(cookie);
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute(SessionConst.SESSION_USER);
		return "redirect:/login.action";
	}

}
