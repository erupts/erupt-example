package com.example.demo.model;
/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Erupt(name = "学生管理")
@Table(name = "t_student")
@Entity
public class Student extends BaseModel {

    @EruptField(
            views = @View(
                    title = "姓名", sortable = true
            ),
            edit = @Edit(
                    title = "姓名",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "年龄", sortable = true
            ),
            edit = @Edit(
                    title = "年龄",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer age;

    @EruptField(
            views = @View(
                    title = "地图"
            ),
            edit = @Edit(
                    title = "地图",
                    type = EditType.MAP, search = @Search, notNull = true
            )
    )
    private String map;

    @EruptField(
            views = @View(
                    title = "生日", sortable = true
            ),
            edit = @Edit(
                    title = "生日",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType
            )
    )
    private Date birthday;

    @EruptField(
            views = @View(
                    title = "性别", sortable = true
            ),
            edit = @Edit(
                    title = "性别",
                    type = EditType.BOOLEAN, search = @Search, notNull = true,
                    boolType = @BoolType
            )
    )
    private Boolean gender;

}