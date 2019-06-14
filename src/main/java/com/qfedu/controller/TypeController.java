package com.qfedu.controller;

import com.qfedu.pojo.SearchType;
import com.qfedu.service.TypeService;
import com.qfedu.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/list.do")
    public JsonBean findAllTypes(){
        List<SearchType> list = typeService.findAllType();
        return new JsonBean(1, list);
    }
}






