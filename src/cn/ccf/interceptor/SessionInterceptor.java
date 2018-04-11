package cn.ccf.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.constants.SessionConst;
import cn.ccf.forum.model.Person;
import cn.ccf.forum.util.PersonUtil;
import cn.ccf.pojo.SessionUser;
import cn.ccf.pojo.User;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// 后台session控制
		String[] noFilters = new String[] { "login.action", "handleLogin.action" };

		String uri = request.getRequestURI();

		boolean noFileter = false;
		for (String s : noFilters) {
			if (uri.indexOf(s) != -1) {
				noFileter = true;
				break;
			}
		}

		if (noFileter) {
			return super.preHandle(request, response, handler);
		}

		Object su = request.getSession().getAttribute(SessionConst.SESSION_USER);
		if (su == null) {
			Cookie cs[] = request.getCookies();
			for (int i = 0; cs != null && i < cs.length; i++) {
				Cookie c = cs[i];
				if (SessionConst.COOKIE_NAME.equals(c.getName())) {
					String value = c.getValue();
					JSONObject jsonObject = JSONObject.parseObject(new String(org.apache.commons.codec.binary.Base64.decodeBase64(value)));
					JSONObject userJsonObject = jsonObject.getJSONObject("user");
					Integer role = jsonObject.getInteger("role");
					JSONObject personJsonObject = jsonObject.getJSONObject("person");
					if (userJsonObject != null) {
						User user = JSONObject.toJavaObject(userJsonObject, User.class);
						SessionUser sessionUser = new SessionUser(user);
						sessionUser.setRole(role);
						request.getSession().setAttribute(SessionConst.SESSION_USER, sessionUser);
						request.getSession().setMaxInactiveInterval(3 * 60 * 60);

						if (personJsonObject != null) {
							PersonUtil.setPersonInf(request, response, JSONObject.toJavaObject(personJsonObject, Person.class));
						}

					} else {
						response.sendRedirect(request.getServletContext().getContextPath() + "/login.action");
						return false;
					}

					return super.preHandle(request, response, handler);
				}
			}

			response.sendRedirect(request.getServletContext().getContextPath() + "/login.action");
			return false;
		}

		return super.preHandle(request, response, handler);
	}

}
