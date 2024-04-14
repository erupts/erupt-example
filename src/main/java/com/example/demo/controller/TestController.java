package com.example.demo.controller;

import com.example.demo.model.Article;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.erupt.jpa.dao.EruptDao;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private EruptDao eruptDao;

    //获取文章列表
    @RequestMapping("/list")
    public List<Article> testArticle() {
        // Erupt jdbc方式查询
        return eruptDao.lambdaQuery(Article.class)
                .eq(Article::getTop, false)
                .limit(10).list();
    }

}