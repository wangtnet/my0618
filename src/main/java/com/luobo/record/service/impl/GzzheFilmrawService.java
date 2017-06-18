package com.luobo.record.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luobo.record.dao.IGzzheFilmrawDao;
import com.luobo.record.pojo.GzzheFilmraw;
import com.luobo.record.service.IGzzheFilmrawService;

@Service("gzzheFilmrawService")
public class GzzheFilmrawService implements IGzzheFilmrawService {
	
	@Resource
	private IGzzheFilmrawDao gzzheFilmrawDao;

	@Override
	public GzzheFilmraw selectByPrimaryKey(Long filmid) {
		// TODO Auto-generated method stub
		return gzzheFilmrawDao.selectByPrimaryKey(filmid);
	}

	@Override
	public List<GzzheFilmraw> selectTwentyByNo(Long no) {
		// TODO Auto-generated method stub
		return gzzheFilmrawDao.selectTwentyByNo(no);
	}

	@Override
	public List<GzzheFilmraw> selectByNameSearch(String title) {
		// TODO Auto-generated method stub
		return gzzheFilmrawDao.selectByNameSearch("%"+title+"%");
	}
	
}
