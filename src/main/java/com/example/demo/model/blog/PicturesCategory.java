package com.example.demo.model.blog;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.upms.model.base.HyperModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author YuePeng
 * date 2020-05-28
 */
@Erupt(
        name = "图床分类",
        orderBy = "sort"
)
@Table(name = "blog_picture_category")
@Entity
public class PicturesCategory extends HyperModel {

    @EruptField(
            views = @View(title = "名称"),
            edit = @Edit(title = "名称", notNull = true)
    )
    private String name;

    @EruptField(
            views = @View(title = "排序"),
            edit = @Edit(title = "排序", notNull = true)
    )
    private Integer sort;

}
