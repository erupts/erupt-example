package com.example.demo.model.complex;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.jpa.model.BaseModel;

import java.util.Date;


@Erupt(name = "complex dialog")
public class ComplexDialog extends BaseModel {

    @EruptField(
            edit = @Edit(title = "文本", notNull = true)
    )
    private String text;

    @EruptField(
            edit = @Edit(title = "时间", notNull = true)
    )
    private Date date;

    @EruptField(
            edit = @Edit(title = "数值", notNull = true)
    )
    private Long number;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
