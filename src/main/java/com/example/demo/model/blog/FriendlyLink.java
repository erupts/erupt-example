package com.example.demo.model.blog;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author YuePeng
 * date 2020/12/15 12:11
 */
@Erupt(
        name = "友情链接",
        orderBy = "sort"
)
@Table(name = "blog_link")
@Entity
public class FriendlyLink extends BaseModel {

    @EruptField(
            views = @View(title = "友链名"),
            edit = @Edit(title = "友链名", notNull = true)
    )
    private String name;

    @EruptField(
            views = @View(title = "友链简介"),
            edit = @Edit(title = "友链简介", notNull = true)
    )
    private String remark;

    @EruptField(
            views = @View(title = "友链URL", type = ViewType.LINK_DIALOG),
            edit = @Edit(title = "友链URL", notNull = true)
    )
    private String url;

    @EruptField(
            views = @View(title = "站长邮箱"),
            edit = @Edit(title = "站长邮箱")
    )
    private String email;

    @EruptField(
            views = @View(title = "排序"),
            edit = @Edit(title = "排序")
    )
    private Integer sort;

}
