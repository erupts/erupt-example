package com.example.demo.dao;

import com.example.demo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 直接继承 JpaRepository 就有了增删改查等能力，该功能由 spring-data-jpa 提供
 * 泛型说明：Article 实体类对象  Long 主键数据类型
 *
 * @author liyuepeng
 * @date 2021/1/6 18:31
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    //方法名称必须要遵循驼峰式命名规则，findBy（关键字）+属性名称（首字母大写）+查询条件（首字母大写）
    List<Article> findByTitle(String title); //根据标题查找文章

}
