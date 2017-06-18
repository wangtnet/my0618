package com.luobo.record.dao;

import java.util.List;

import com.luobo.record.pojo.GzzheFilmraw;

public interface IGzzheFilmrawDao {
    int deleteByPrimaryKey(Long filmid);

    int insert(GzzheFilmraw record);

    int insertSelective(GzzheFilmraw record);

    GzzheFilmraw selectByPrimaryKey(Long filmid);
    
    List <GzzheFilmraw> selectTwentyByNo(Long no);
    
    List <GzzheFilmraw> selectByNameSearch(String title);
    
    GzzheFilmraw selectByUrl(String url);

    int updateByPrimaryKeySelective(GzzheFilmraw record);

    int updateByPrimaryKey(GzzheFilmraw record);
}