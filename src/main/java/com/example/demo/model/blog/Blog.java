package com.example.demo.model.blog;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;

import jakarta.persistence.*;

/**
 * @author YuePeng
 * date 2020/12/15 12:06
 */
@Erupt(
        name = "博客管理",
        linkTree = @LinkTree(field = "blogCategory")
)
@Table(name = "blog_article")
@Entity
public class Blog extends HyperModel {

    @EruptField(
            views = {
                    @View(title = "标题图", type = ViewType.IMAGE)
            },
            edit = @Edit(title = "标题图", notNull = true, type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String image;

    @EruptField(
            views = @View(title = "标题"),
            edit = @Edit(title = "标题", notNull = true, search = @Search(vague = true), inputType = @InputType(fullSpan = true))
    )
    private String name;

//    @EruptField(
//            views = @View(title = "简介", type = ViewType.HTML),
//            edit = @Edit(title = "简介", notNull = true, search = @Search(vague = true), inputType = @InputType(fullSpan = true))
//    )
//    private String intro;

    @EruptField(
            views = @View(title = "是否原创"),
            edit = @Edit(title = "是否原创", notNull = true)
    )
    private Boolean original;

    @EruptField(
            views = @View(title = "是否发布"),
            edit = @Edit(title = "是否发布", notNull = true)
    )
    private Boolean publish;

    @EruptField(
            views = @View(title = "推荐等级"),
            edit = @Edit(title = "推荐等级", notNull = true, type = EditType.CHOICE,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "0", label = "正常"),
                            @VL(value = "10", label = "一级推荐"),
                            @VL(value = "20", label = "二级推荐"),
                            @VL(value = "30", label = "三级推荐")
                    }))
    )
    private Integer recommendedLevel;

    @ManyToOne
    @EruptField(
            views = @View(title = "分类", column = "name"),
            edit = @Edit(title = "分类", notNull = true, type = EditType.REFERENCE_TREE)
    )
    private BlogCategory blogCategory;

    @EruptField(
            views = @View(title = "标签", template = "value&&value.replace(/\\|/g,'<span class=\"text-red\"> | </span>')"),
            edit = @Edit(title = "标签", notNull = true, type = EditType.TAGS,
                    tagsType = @TagsType(fetchHandler = BlogTagHandler.class)
            )
    )
    private String tag;

    @Column(length = 10_485_760)
    @EruptField(
            views = @View(title = "内容", type = ViewType.HTML),
            edit = @Edit(title = "内容", notNull = true, type = EditType.HTML_EDITOR)
    )
    private String content;

    @EruptField(
            views = @View(title = "备注"),
            edit = @Edit(title = "备注", type = EditType.TEXTAREA)
    )
    private String remark;

    @EruptField(
            views = @View(title = "点击数")
    )
    private Integer clickNum = 0; //需要通过前端接口向数据库写入！

}
