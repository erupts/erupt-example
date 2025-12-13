package com.example.demo.model.blog;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.upms.model.base.HyperModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author YuePeng
 * date 2020/12/15 12:06
 */
@Erupt(
        name = "博客标签",
        desc = "sort"
)
@Table(name = "blog_tag")
@Entity
public class BlogTag extends HyperModel {


    @EruptField(
            views = @View(title = "标签名称"),
            edit = @Edit(title = "标签名称", notNull = true, search = @Search(vague = true), inputType = @InputType(fullSpan = true))
    )
    private String name;

    @EruptField(
            views = @View(title = "排序"),
            edit = @Edit(title = "排序", notNull = true)
    )
    private Integer sort;

    public String getName() {
        return name;
    }
}
