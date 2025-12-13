package com.example.demo.model;

import com.example.demo.handler.AutoCompleteHandlerImpl;
import com.example.demo.handler.ComponentDataProxy;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liyuepeng
 * @date 2020-02-29
 */
@Erupt(
        name = "组件示例",
        dataProxy = ComponentDataProxy.class //事件代理，非常有用的功能 ！
)
@Table(name = "demo_component")
@Entity
public class Component extends BaseModel {

    @EruptField(
            views = @View(title = "文本"),
            edit = @Edit(title = "文本", search = @Search(vague = true))
    )
    private String input;

    @EruptField(
            views = @View(title = "数字"),
            edit = @Edit(title = "数字", search = @Search(vague = true))
    )
    private Double number1;

    @EruptField(
            views = @View(title = "数字滑块"),
            edit = @Edit(title = "数字滑块", type = EditType.SLIDER)
    )
    private Integer slider;

    @EruptField(
            views = @View(title = "布尔"),
            edit = @Edit(title = "布尔", search = @Search)
    )
    private Boolean bool;

    @EruptField(
            views = @View(title = "自动完成"),
            edit = @Edit(title = "自动完成", search = @Search(vague = true), type = EditType.AUTO_COMPLETE,
                    autoCompleteType = @AutoCompleteType(handler = AutoCompleteHandlerImpl.class))
    )
    private String autoComplete;

    @EruptField(
            views = @View(title = "颜色选择"),
            edit = @Edit(title = "颜色选择", search = @Search(vague = true), inputType = @InputType(type = "color"))
    )
    private String color;

    @EruptField(
            views = @View(title = "周选择器"),
            edit = @Edit(title = "周选择器", search = @Search(vague = true), inputType = @InputType(type = "week"))
    )
    private String weekInput;

    @ManyToOne
    @EruptField(
            edit = @Edit(title = "文章选择", type = EditType.REFERENCE_TABLE,
                    referenceTableType = @ReferenceTableType(label = "title"))
    )
    private Article article;

    @ManyToOne
    @EruptField(
            edit = @Edit(title = "多对一树", search = @Search, type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name", pid = "parent.id"))
    )
    private TreeView tree;

    @EruptField(
            views = @View(title = "标签选择"),
            edit = @Edit(title = "标签选择", search = @Search, type = EditType.TAGS)
    )
    private String tags;

    @Transient
    @EruptField(
            edit = @Edit(title = "时间选择", type = EditType.DIVIDE)
    )
    private String dateDiv;

    @EruptField(
            views = @View(title = "日期"),
            edit = @Edit(title = "日期", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE), search = @Search(vague = true))
    )
    private LocalDate date1;

    @EruptField(
            views = @View(title = "时间日期"),
            edit = @Edit(title = "时间日期", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME), search = @Search(vague = true))
    )
    private LocalDateTime dateTime;

    @EruptField(
            views = @View(title = "时间"),
            edit = @Edit(title = "时间", type = EditType.DATE, dateType = @DateType(type = DateType.Type.TIME), search = @Search)
    )
    private String time;

    @EruptField(
            views = @View(title = "周"),
            edit = @Edit(title = "周", type = EditType.DATE, dateType = @DateType(type = DateType.Type.WEEK), search = @Search)
    )
    private String week;

    @EruptField(
            views = @View(title = "月"),
            edit = @Edit(title = "月", type = EditType.DATE, dateType = @DateType(type = DateType.Type.MONTH), search = @Search)
    )
    private String month;

    @EruptField(
            views = @View(title = "年"),
            edit = @Edit(title = "年", type = EditType.DATE, dateType = @DateType(type = DateType.Type.YEAR), search = @Search)
    )
    private String year;

    @EruptField(
            views = @View(title = "过去时间"),
            edit = @Edit(title = "过去时间", type = EditType.DATE, dateType = @DateType(pickerMode = DateType.PickerMode.HISTORY), search = @Search)
    )
    private String history;

    @EruptField(
            views = @View(title = "未来时间"),
            edit = @Edit(title = "未来时间", type = EditType.DATE, dateType = @DateType(pickerMode = DateType.PickerMode.FUTURE), search = @Search)
    )
    private String feature;

    public void setInput(String input) {
        this.input = input;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
