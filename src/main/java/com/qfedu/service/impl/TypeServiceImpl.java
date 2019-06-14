package com.qfedu.service.impl;

import com.qfedu.dao.TypeDao;
import com.qfedu.pojo.SearchType;
import com.qfedu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired(required = false)
    private TypeDao typeDao;

    @Override
    public List<SearchType> findAllType() {
        return typeDao.findAll();
    }
}





