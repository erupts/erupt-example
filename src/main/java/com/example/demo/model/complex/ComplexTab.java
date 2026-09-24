package com.example.demo.model.complex;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author liyuepeng
 * @date 2021-01-02.
 */
@Erupt(name = "一对多新增")
@Table(name = "demo_complex_tab")
@Entity
public class ComplexTab extends BaseModel {

    @EruptField(
            views = @View(title = "文本"),
            edit = @Edit(title = "文本", notNull = true)
    )
    private String input;

    @EruptField(
            views = @View(title = "数值", sortable = true),
            edit = @Edit(title = "数值")
    )
    private Float number;

}
