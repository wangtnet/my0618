package com.luobo.record.service;

import java.util.List;

import com.luobo.record.pojo.GzzheFilmraw;

public interface IGzzheFilmrawService {
	GzzheFilmraw selectByPrimaryKey(Long filmid);
	
	List <GzzheFilmraw> selectTwentyByNo(Long no);
	
	List <GzzheFilmraw> selectByNameSearch(String title);
}
