package com.example.demo.model.mall;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author YuePeng
 * date 2020/12/11 13:29
 */
@Erupt(name = "优惠券管理")
@Table(name = "mall_goods_coupon")
@Entity
public class Coupon extends BaseModel {

    @EruptField(
            views = @View(title = "名称"),
            edit = @Edit(title = "名称", notNull = true, search = @Search, inputType = @InputType(fullSpan = true))
    )
    private String name;

    @EruptField(
            views = @View(title = "金额"),
            edit = @Edit(title = "金额", notNull = true, search = @Search)
    )
    private Double price;

    @EruptField(
            views = @View(title = "商品金额满多少可用"),
            edit = @Edit(title = "商品金额满多少可用", notNull = true, search = @Search)
    )
    private Double priceMax;

    @EruptField(
            views = @View(title = "发行量"),
            edit = @Edit(title = "发行量", notNull = true, search = @Search(vague = true))
    )
    private Integer maxCount;

    @EruptField(
            views = @View(title = "颜色", template = "'<div style=\"width:100%;height:20px;background:'+value+'\"></div>'"),
            edit = @Edit(title = "颜色", notNull = true, inputType = @InputType(type = "color"))
    )
    private String color;

    @EruptField(
            views = @View(title = "生效时间"),
            edit = @Edit(title = "生效时间", notNull = true, dateType = @DateType(type = DateType.Type.DATE_TIME))
    )
    private LocalDateTime startTime;

    @EruptField(
            views = @View(title = "失效时间"),
            edit = @Edit(title = "失效时间", notNull = true, dateType = @DateType(type = DateType.Type.DATE_TIME))
    )
    private LocalDateTime endTime;

    @ManyToOne
    @EruptField(
            views = @View(title = "指定类别商品可用", column = "name"),
            edit = @Edit(title = "指定类别商品可用", desc = "不选择全场可用", type = EditType.REFERENCE_TREE, search = @Search, referenceTreeType = @ReferenceTreeType(pid = "parent.id"))
    )
    private GoodsCategory category;

}
