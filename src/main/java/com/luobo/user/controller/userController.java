package com.luobo.user.controller;

import java.io.IOException;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luobo.common.VerifyCodeUtils;
import com.luobo.user.pojo.user;
import com.luobo.user.service.IUserService;


@Controller
@RequestMapping("/user")
public class userController {

	static private Hashtable hashCheckCode=new Hashtable(2,(float)0.8);
	
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="register")
	public  @ResponseBody  
	String register(user u){
		int r = userService.register(u);
		System.out.println(u.toString()+"r="+r);
		return "Result:"+r;
	}
	
	//
	@RequestMapping(value="checkRegistercode")
	public  @ResponseBody  
	boolean checkRegistercode(HttpServletRequest request,String registercode){
		String ssid = request.getSession().getId();
		if(hashCheckCode.get(ssid)==null) return false;
		
		String code =(String)hashCheckCode.get(ssid);
		System.out.println(ssid+" get "+code+"   "+registercode);
		if(code.equals(registercode))  
		{
			System.out.println("true");
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="checkCode")
	public  @ResponseBody  
	void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
	            throws IOException {
		
		String ssid = request.getSession().getId();
		
		int w = 90, h = 30;
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		response.getOutputStream().flush();
		if(hashCheckCode.get(ssid)==null){
			hashCheckCode.put(ssid, verifyCode);
			System.out.println(ssid+" put "+verifyCode);
		}else{
			hashCheckCode.remove(ssid);
			System.out.println(ssid+"delete");
			hashCheckCode.put(ssid, verifyCode);
			System.out.println(ssid+" put "+verifyCode);
		}
		System.out.println(hashCheckCode.get(ssid));
	}
	
}
