package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.InfoDao;
import com.qfedu.pojo.SearchInfo;
import com.qfedu.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired(required = false)
    private InfoDao infoDao;
    @Override
    public Map<String, Object> findByPage(Integer pageNum, Integer limit) {

        PageHelper.startPage(pageNum, limit);
        List<SearchInfo> list = infoDao.findAll();

        Map<String, Object> map = new HashMap<>();
        map.put("totalPage", ((Page)list).getPages());// 总页数
        map.put("count", ((Page)list).getTotal());// 总记录数
        map.put("currentPage", pageNum);
        map.put("list", list);

        return map;
    }

    @Override
    public Map<String, Object> findByCondition(Integer pageNum, Integer limit, String keyword) {
        PageHelper.startPage(pageNum, limit);
        List<SearchInfo> list = infoDao.findByKeyword(keyword);

        Map<String, Object> map = new HashMap<>();
        map.put("totalPage", ((Page)list).getPages());// 总页数
        map.put("count", ((Page)list).getTotal());// 总记录数
        map.put("currentPage", pageNum);
        map.put("list", list);

        return map;
    }


    @Override
    public void addInfo(SearchInfo info) {
        infoDao.add(info);
    }
}






