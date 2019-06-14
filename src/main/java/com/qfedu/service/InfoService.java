package com.qfedu.service;

import com.qfedu.pojo.SearchInfo;

import java.util.Map;

public interface InfoService {

    public Map<String, Object> findByPage(Integer pageNum, Integer limit);

    public Map<String, Object> findByCondition(Integer pageNum, Integer limit, String keyword);

    public void addInfo(SearchInfo info);

}
