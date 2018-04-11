package cn.ccf.forum.Controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ccf.forum.mapper.PersonMapper;
import cn.ccf.forum.model.Board;
import cn.ccf.forum.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.forum.util.PersonInfo;
import cn.ccf.forum.util.PersonUtil;
import cn.ccf.forum.Service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonMapper personMapper;
	
	@RequestMapping("person_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		request.setAttribute("title", "用户注册");
		request.setAttribute("person", new Person());
		return new ModelAndView("forum/person/addPerson");
	}
	
	
	/**
	 * @author zc
	 * description : 远程传输用户名和密码
	 * @param person
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("jumpToForum")
	public String jumpToForm(Person person, HttpServletRequest request, HttpServletResponse response) {
		try {
			person.setAccount(new String(person.getAccount().getBytes("iso-8859-1"),"utf-8" ));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		Person person1=personService.getPerson(person);
		PersonUtil.setPersonInf(request, response, person1);
		person1.setIplastactived(request.getRemoteAddr());
		person1.setDatelastactived(new Date());
		personService.save(person1);
		return "redirect:category_list.do";
	}
	
	
	
	@RequestMapping("person_add.do")
	public ModelAndView add(@ModelAttribute Person person, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("title", "用户注册");
		person.setIpcreated(request.getRemoteAddr());
		person.setIplastactived(request.getRemoteAddr());
		person.setDatecreated(new Date());
		person.setDatelastactived(new Date());
		person.setDeleted(false);
		
		if (person.getAccount() == null|| person.getAccount().trim().length() == 0) {
			request.setAttribute("message", "请输入帐号");
			return initAdd(request);
		}
		
		if (person.getPassword() == null|| person.getPassword().trim().length() == 0|| !person.getPassword().equals(request.getParameter("password1"))) {
			request.setAttribute("message", "密码不一致");
			return initAdd(request);
		}
		try {
			personService.insert(person);//保存到数据库，此时没有id
			PersonUtil.setPersonInf(request, response, personService.findPersonByAccount(person.getAccount()));
			request.setAttribute("message", "注册成功");
			return new ModelAndView("person/success");
		} catch (Exception e) {
			request.setAttribute("message", "注册失败，原因：" + e.getMessage());
			return initAdd(request);
		}
	}
	
	@RequestMapping("person_initLogin.do")
	public ModelAndView initLogin(HttpServletRequest request){
		request.setAttribute("person", new Person());
		request.setAttribute("title", "用户登录");
		return new ModelAndView("forum/person/login");
	}
	
	@RequestMapping("person_login.do")
	public String login(@ModelAttribute Person person,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setAttribute("title", "用户登录");
		Person person1=personService.getPerson(person);
		if (person1 == null)
			throw new AccountException("用户名密码错误");
		PersonUtil.setPersonInf(request, response, person1);
		person1.setIplastactived(request.getRemoteAddr());
		person1.setDatelastactived(new Date());
		personService.save(person1);
		request.setAttribute("message", "欢迎回来");
		//return new ModelAndView("person/success");
		return "redirect:category_list.do";
	}
	
	@RequestMapping("person_logout.do")
	public ModelAndView logout(HttpServletRequest request){
		request.setAttribute("title", "用户注销");
		request.getSession(true).setAttribute(PersonUtil.PERSON_INFO, null);
		request.setAttribute("person", new Person());
		return new ModelAndView("forum/person/login");
	}
	
	@RequestMapping("person_view.do")
	public ModelAndView view(HttpServletRequest request){
		request.setAttribute("title", "查看用户资料");
		int id=Integer.parseInt(request.getParameter("id"));
		Person person=personService.selectById(id);
		request.setAttribute("person", person);
		List<Board> boardList=personService.selectBoardByPersonId(id);
		request.setAttribute("boardList", boardList);
		return new ModelAndView("forum/person/viewPerson");
	}
	
	/**
	 * @author zc
	 */
	@RequestMapping("viewPersonalCenter.do")
	public String viewPersonalCenter(HttpServletRequest req) {
		req.setAttribute("title", "查看用户资料");
		int id=Integer.parseInt(req.getParameter("id"));
		Person person=personService.selectById(id);
		req.setAttribute("person", person);
		List<Board> boardList=personService.selectBoardByPersonId(id);
		req.setAttribute("boardList", boardList);
		return "forum/person/personalCenter";
	}
	
	@RequestMapping(value="modifyPersonalInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject modifyPersonalInfo(HttpServletRequest req, @RequestBody Person newPerson) {
		
		//{"name":name, "sex":sex, "email":email, "birthday":birthday},
		
		int id = ((PersonInfo)req.getSession().getAttribute("personInfo")).getId();
		Person person = personService.selectById(id);
		
		person.setName(newPerson.getName());
		person.setSex(newPerson.getSex());
		person.setBirthday(newPerson.getBirthday());
		person.setEmail(newPerson.getEmail());
		
		personMapper.updateByPrimaryKey(person);
		
		JSONObject json = new JSONObject();
		json.put("succ", "执行成功");
		return json;
	}
}
