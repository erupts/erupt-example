package com.example.demo.model.mall;

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
import java.util.Set;

@Erupt(name = "商品管理", linkTree = @LinkTree(field = "category"))
@Table(name = "mall_goods")
@Entity
public class Goods extends HyperModel {

    @EruptField(
            views = @View(title = "商品图片"),
            edit = @Edit(title = "商品图片", notNull = true, type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE, maxLimit = 6))
    )
    private String image;

    @EruptField(
            views = @View(title = "商品名称"),
            edit = @Edit(title = "商品名称", notNull = true, inputType = @InputType(fullSpan = true), search = @Search(vague = true))
    )
    private String name;

    @ManyToOne
    @EruptField(
            views = @View(title = "所属分类", column = "name"),
            edit = @Edit(title = "所属分类", type = EditType.REFERENCE_TREE, search = @Search, notNull = true, referenceTreeType = @ReferenceTreeType(pid = "parent.id"))
    )
    private GoodsCategory category;

//    @EruptField(
//            views = @View(title = "价格"),
//            edit = @Edit(title = "价格",notNull = true, numberType = @NumberType(min = 0))
//    )
//    private Double price;

    @EruptField(
            views = @View(title = "运费"),
            edit = @Edit(title = "运费", notNull = true, search = @Search(vague = true))
    )
    private final Double freight = 0D;

    @EruptField(
            views = @View(title = "商品状态"),
            edit = @Edit(title = "商品状态", notNull = true, boolType = @BoolType(trueText = "上架", falseText = "下架"), search = @Search)
    )
    private Boolean status;

    @Column(length = 10_485_760)
    @EruptField(
            views = @View(title = "商品描述", type = ViewType.HTML),
            edit = @Edit(title = "商品描述", type = EditType.HTML_EDITOR)
    )
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "goods_id")
    @EruptField(
            edit = @Edit(title = "商品型号", type = EditType.TAB_TABLE_ADD)
    )
    private Set<GoodsSpec> goodsSpecs;

}
