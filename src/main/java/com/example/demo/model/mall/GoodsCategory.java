package com.example.demo.model.mall;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Erupt(name = "商品类别", tree = @Tree(pid = "parent.id"), orderBy = "GoodsCategory.sort")
@Table(name = "mall_goods_category")
@Entity
public class GoodsCategory extends BaseModel {

    @EruptField(
            edit = @Edit(title = "分类图片", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE))
    )
    private String image;

    @EruptField(
            edit = @Edit(title = "类别名称", notNull = true)
    )
    private String name;

    @EruptField(
            edit = @Edit(title = "显示顺序")
    )
    private Integer sort;

    @ManyToOne
    @EruptField(
            edit = @Edit(title = "上级分类", type = EditType.REFERENCE_TREE, referenceTreeType = @ReferenceTreeType(pid = "parent.id"))
    )
    private GoodsCategory parent;


}
