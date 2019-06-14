package com.qfedu.controller;

import com.qfedu.pojo.SearchInfo;
import com.qfedu.pojo.SearchType;
import com.qfedu.service.InfoService;
import com.qfedu.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController// @Controller + @ResponseBody
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/list.do")
    public JsonBean findByPage(Integer page, Integer limit, String keyword){
        Map<String, Object> map = null;
        if(keyword != null && !keyword.equals("")){
            map = infoService.findByCondition(page, limit, keyword);
        }else{
            map = infoService.findByPage(page, limit);
        }
        return new JsonBean(1, map);
    }

    @RequestMapping("/add.do")
    public JsonBean addInfo(SearchInfo info, Integer typeId){
        SearchType type = new SearchType();
        type.setTid(typeId);
        info.setSearchType(type);
        infoService.addInfo(info);

        return new JsonBean(1, null);
    }
}
