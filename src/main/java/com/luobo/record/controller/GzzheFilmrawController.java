package com.luobo.record.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luobo.record.pojo.GzzheFilmraw;
import com.luobo.record.service.IGzzheFilmrawService;

@Controller
@RequestMapping("/record")
public class GzzheFilmrawController {
	
	@Resource
	private IGzzheFilmrawService gzzheFilmrawService;
	
	
	public  @ResponseBody  
	GzzheFilmraw selectByPrimaryKey1()
	{
		return gzzheFilmrawService.selectByPrimaryKey(344l);
	}
	
	@RequestMapping(value="/showone/{pd}")
	public  @ResponseBody  
	GzzheFilmraw selectByPrimaryKey(@PathVariable Long pd)
	{
		return gzzheFilmrawService.selectByPrimaryKey(pd);
	}
	
	
	@RequestMapping(value="/show20/{pageno}")
	public  @ResponseBody  
	List<GzzheFilmraw> selectTwentyByNo(@PathVariable Long pageno)
	{
		return gzzheFilmrawService.selectTwentyByNo((pageno-1)*20+4);
	}
	
	
	@RequestMapping(value="/search/{title}")
	public  @ResponseBody  
	List<GzzheFilmraw> selectTwentyByNo(@PathVariable String title) throws UnsupportedEncodingException
	{
		String searchtext=java.net.URLDecoder.decode(title,"UTF-8");
		System.out.println(searchtext+"title: "+title);
		return gzzheFilmrawService.selectByNameSearch(searchtext);
	}
	
}
