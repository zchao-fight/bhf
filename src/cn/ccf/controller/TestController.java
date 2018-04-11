package cn.ccf.controller;

import cn.ccf.pojo.ResponseDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController extends BaseController {

	
	@RequestMapping(value="/test/getData", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getData(){
		JSONObject json = new JSONObject();
		json.put("aa", 1);
		json.put("bb", 1);
		json.put("cc", 1);
		return json;
		
	}

    @RequestMapping(value="/test/testPost", method=RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String testPost(String username, String password){
        System.out.println(username);
        return "username:"+username + "\tpassword:" + password;
    }


    @RequestMapping(value="/test/testModel", method = RequestMethod.GET)
    @ResponseBody
    public String testModel(Model model, HttpServletRequest request){
        model.addAttribute("name", "zc");

        /*
        getAttribute获取的是对象，而getParameter获取的是字符串。
        request.getAttribute("username")是获取容器里面的值，在整个容器中有效，如tomcat
        request.getParameter("username") 是获取上一个页面传入本页面的值
        */

        request.getParameter("key");
        request.getAttribute("key");
        return null;
    }
}
