package com.example.demo.model.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.TagsFetchHandler;
import xyz.erupt.jpa.dao.EruptDao;

import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author YuePeng
 * date 2020/12/15 13:47
 */
@Component
public class BlogTagHandler implements TagsFetchHandler {

    @Resource
    private EruptDao eruptDao;

    @Override
    public List<String> fetchTags(String[] params) {
        return eruptDao.lambdaQuery(BlogTag.class).listSelect(BlogTag::getName);
    }
}
