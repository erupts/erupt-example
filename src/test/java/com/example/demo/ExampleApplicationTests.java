package com.example.demo;

import com.example.demo.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.erupt.jpa.dao.EruptDao;

import jakarta.annotation.Resource;
import java.util.List;

@SpringBootTest
class ExampleApplicationTests {


    @Resource
    private EruptDao eruptDao;

    //查询
    @Test
    public void query() {
        List<Article> articles = eruptDao.lambdaQuery(Article.class)
                .eq(Article::getTopUp, false).list();
        System.out.println(articles);
    }


}
