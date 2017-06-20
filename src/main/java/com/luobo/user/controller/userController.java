package com.luobo.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(
            @RequestParam("one-specific-file") CommonsMultipartFile upfile,
            HttpServletRequest req) throws IOException {
        // |获取在Web服务器上的 绝对路径

        System.out.println("come");
        String path = req.getRealPath("/WEB-INF/static/");
        System.out.println(path);
        // |获取输入流
        InputStream is = upfile.getInputStream();
        // |文件输出流
        OutputStream os = new FileOutputStream(new File(path,upfile.getOriginalFilename()));

        System.out.println("come0");
        // |循环写入
        int length = 0;
        byte[] buffer = new byte[128];
        while ((length = is.read(buffer)) != -1) {
            os.write(buffer, 0, length);
        }
        System.out.println("come1");
        is.close();
        os.close();
        // ===渲染===
        System.out.println("come2");
        // ModelAndView mView = new ModelAndView();
        // mView.setViewName("upload");
        // |返回至渲染器
        return null;
    }
}
