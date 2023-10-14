package com.example.demo.controller;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.erupt.jpa.dao.EruptDao;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ArticleRepository articleRepository;

    @Resource
    private EruptDao eruptDao;

    //获取文章列表
    @RequestMapping("/test")
    public List<Article> testArticle() {
        // Erupt jdbc方式调用
        return eruptDao.queryEntityList(Article.class);
        // JPA jdbc方式调用
        //  return articleRepository.findAll();
    }

}