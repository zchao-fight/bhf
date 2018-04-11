package cn.ccf.controller;

public abstract class BaseController {

	public String forword(String path) {
		return "WEB-INF/jsp/" + path;
	}
	
}
