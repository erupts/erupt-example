package com.example.demo.model.complex;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author YuePeng
 * date 2023/4/2 21:47
 */
@Erupt(name = "complex_ext")
@Entity
@Table(name = "demo_complex_ext")
public class ComplexExt extends BaseModel {

    @EruptField(
            views = @View(title = "姓名"),
            edit = @Edit(title = "姓名", notNull = true)
    )
    private String name;

    @EruptField(
            views = @View(title = "性别"),
            edit = @Edit(title = "性别",
                    boolType = @BoolType(trueText = "男", falseText = "女"))
    )
    private Boolean sex;

}
