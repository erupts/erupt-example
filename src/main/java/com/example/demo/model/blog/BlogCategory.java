package com.example.demo.model.blog;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author YuePeng
 * date 2020/12/15 12:07
 */
@Erupt(
        name = "博客类别",
        desc = "sort"
)
@Table(name = "blog_category")
@Entity
public class BlogCategory extends BaseModel {

    @EruptField(
            views = @View(title = "名称"),
            edit = @Edit(title = "名称", notNull = true, search = @Search(vague = true))
    )
    private String name;

    @EruptField(
            views = @View(title = "顺序"),
            edit = @Edit(title = "顺序", notNull = true)
    )
    private Integer sort;

    @EruptField(
            views = @View(title = "是否显示"),
            edit = @Edit(title = "是否显示", notNull = true)
    )
    private Boolean isShow;

    @EruptField(
            views = @View(title = "分类介绍"),
            edit = @Edit(title = "分类介绍", type = EditType.TEXTAREA)
    )
    private String remark;

}
