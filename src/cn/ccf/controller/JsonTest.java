package cn.ccf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;   

import cn.ccf.pojo.User;

@Controller
public class JsonTest {
	
	//请求json响应json，请求用户信息，用户信息用json格式 呼出用户信息
	@RequestMapping(value="/getRequestUser", method = RequestMethod.POST)
	@ResponseBody
	public  User getUser(@RequestBody User user) throws Exception {
		return user;
	}
	
	//请求的是key/value响应的的是json
	@RequestMapping("/getResponseUser")
	@ResponseBody
	public  User getResponseUser(User user) throws Exception {
		return user;
	}
	
	@RequestMapping("/jsontest")
	public String testJson() {
		return "jsontest";
	}
}