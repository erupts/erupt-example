package com.example.demo.model.mall;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Erupt(name = "商品型号")
@Table(name = "mall_goods_spec")
@Entity
public class GoodsSpec extends BaseModel {

    @EruptField(
            views = @View(title = "名称"),
            edit = @Edit(title = "名称", notNull = true)
    )
    private String name;

    @EruptField(
            views = @View(title = "价格"),
            edit = @Edit(title = "价格", notNull = true)
    )
    private Double price;

    @EruptField(
            views = @View(title = "库存"),
            edit = @Edit(title = "库存", notNull = true)
    )
    private Integer inventory;
}
