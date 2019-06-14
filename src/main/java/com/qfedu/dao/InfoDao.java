package com.qfedu.dao;

import com.qfedu.pojo.SearchInfo;

import java.util.List;

public interface InfoDao {

    public List<SearchInfo> findAll();

    public List<SearchInfo> findByKeyword(String keyword);

    public void add(SearchInfo info);

}
