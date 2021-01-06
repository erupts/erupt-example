package com.example.demo.model;

import com.example.demo.handler.OperationHandlerImpl;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.expr.ExprBool;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.RowOperation;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.upms.handler.DictChoiceFetchHandler;
import xyz.erupt.upms.handler.SqlChoiceFetchHandler;
import xyz.erupt.upms.handler.ViaMenuCtrl;

import javax.persistence.*;
import java.util.Set;

/**
 * @author liyuepeng
 * @date 2021-01-02.
 */
@Erupt(
        name = "复杂示例",
        rowOperation = {
                @RowOperation(
                        operationHandler = OperationHandlerImpl.class,
                        mode = RowOperation.Mode.SINGLE,
                        title = "单行操作",
                        code = "SINGLE"),
                @RowOperation(title = "多行操作",
                        show = @ExprBool(
                                exprHandler = ViaMenuCtrl.class,
                                params = "ComplexBtn"  //将ComplexBtn添加到菜单可控制该按钮的显示隐藏
                        ),
                        code = "MULTI",
                        icon = "fa fa-check-square",
                        operationHandler = OperationHandlerImpl.class),
                @RowOperation(
                        eruptClass = ComplexOperator.class, //提交前需要填写该类中定义的表单
                        operationHandler = OperationHandlerImpl.class,
                        mode = RowOperation.Mode.BUTTON,
                        tip = "不依赖任何数据即可执行",
                        title = "按钮操作",
                        code = "BUTTON",
                        icon = "fa fa-google-wallet")
        },
        linkTree = @LinkTree(field = "tree")
)
@Table(name = "demo_complex")
@Entity
public class Complex extends BaseModel {

    @EruptField(
            views = @View(title = "动态下拉列表"),
            edit = @Edit(
                    search = @Search,
                    title = "通过SQL获取下拉列表",
                    type = EditType.CHOICE,
                    desc = "动态下拉列表",
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            fetchHandlerParams = "select id,name from e_upms_menu"
                    ))
    )
    private String choice;

    @EruptField(
            views = @View(title = "字典值"),
            edit = @Edit(
                    search = @Search,
                    title = "字典值", type = EditType.CHOICE, desc = "动态获取字典项的值",
                    choiceType = @ChoiceType(
                            fetchHandler = DictChoiceFetchHandler.class,
                            fetchHandlerParams = "system" //字典编码，通过字典编码获取字典项列表
                    ))
    )
    private Long fromDict;

    @ManyToOne
    @EruptField(
            edit = @Edit(title = "多对一树", search = @Search, type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name", pid = "parent.id"))
    )
    private TreeView tree;

    @ManyToOne
    @JoinColumn
    @EruptField(
            views = {
                    @View(title = "多对一表格", column = "title"),
            },
            edit = @Edit(title = "多对一表格", type = EditType.REFERENCE_TABLE, search = @Search,
                    referenceTableType = @ReferenceTableType(label = "title")
            )
    )
    private Article article;

    @Lob
    @EruptField(
            views = @View(title = "python代码", type = ViewType.CODE),
            edit = @Edit(title = "python代码编辑器", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "python"))
    )
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "complex_id")
    @EruptField(
            edit = @Edit(title = "一对多新增", type = EditType.TAB_TABLE_ADD)
    )
    private Set<ComplexTab> complexTab;

    @ManyToMany
    @JoinTable(
            name = "e_complex_article",
            joinColumns = @JoinColumn(name = "complex_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"))
    @EruptField(
            edit = @Edit(title = "关联多篇文章", type = EditType.TAB_TABLE_REFER,
                    referenceTableType = @ReferenceTableType(label = "title"))
    )
    private Set<Article> articleTab;

}
