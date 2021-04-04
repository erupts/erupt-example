package com.example.demo.model.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.TagsFetchHandler;
import xyz.erupt.jpa.dao.EruptDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author YuePeng
 * date 2020/12/15 13:47
 */
@Component
public class BlogTagHandler implements TagsFetchHandler {

    @Autowired
    private EruptDao eruptDao;

    @Override
    public List<String> fetchTags(String[] params) {
        List<String> result = new ArrayList<>();
        List<Map<String, Object>> map = eruptDao.queryMapList(BlogTag.class, null, null, "name");
        for (Map<String, Object> objectMap : map) {
            result.add(objectMap.get("name").toString());
        }
        return result;
    }
}
