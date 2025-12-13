package com.example.demo.model.complex;

import com.example.demo.model.Article;
import com.example.demo.model.complex.fun.ComplexDataProxy;
import com.example.demo.model.complex.fun.OperationHandlerImpl;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.expr.ExprBool;
import xyz.erupt.annotation.fun.ChoiceFetchHandler;
import xyz.erupt.annotation.fun.VLModel;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.toolkit.handler.SqlChoiceFetchHandler;
import xyz.erupt.upms.handler.DictCodeChoiceFetchHandler;
import xyz.erupt.upms.handler.ViaMenuValueCtrl;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author YuePeng
 * date 2023-10-08.
 */
@Erupt(
        name = "复杂示例",
        desc = "复杂示例: <a href=\"https://www.erupt.xyz\">erupt</a>",
        power = @Power(export = true, importable = true),
        dataProxy = ComplexDataProxy.class,
        drills = {
                @Drill(title = "下钻", link = @Link(joinColumn = "id", linkErupt = Complex.class, linkCondition = "1 = 1 and Complex.bool = true"))
        },
        rowOperation = {
                @RowOperation(
                        title = "单行操作",
                        operationHandler = OperationHandlerImpl.class,
                        ifExpr = "item.bool",
                        callHint = "",
                        ifExprBehavior = RowOperation.IfExprBehavior.DISABLE,
                        mode = RowOperation.Mode.SINGLE,
                        icon = "fa fa-toggle-on"
                ),
                @RowOperation(
                        title = "多行操作",
                        eruptClass = ComplexDialog.class,
                        operationHandler = OperationHandlerImpl.class
                ),
                @RowOperation(
                        title = "按钮操作",
                        tip = "不依赖任何数据即可执行",
                        mode = RowOperation.Mode.BUTTON,
                        operationHandler = OperationHandlerImpl.class,
                        eruptClass = ComplexDialog.class,
                        show = @ExprBool(exprHandler = ViaMenuValueCtrl.class, params = "ComplexBtn"),
                        icon = "fa fa-google-wallet"
                ),
                @RowOperation(type = RowOperation.Type.TPL, mode = RowOperation.Mode.MULTI,
                        tpl = @Tpl(path = "/tpl/operation.ftl", engine = Tpl.Engine.FreeMarker, width = "80%"),
                        title = "自定义模板",
                        icon = "fa fa-pagelines"
                )
        },
        orderBy = "id",
        layout = @Layout(tableLeftFixed = 1)
)
@Table(name = "demo_complex_pro")
@Entity
public class Complex extends BaseModel implements ChoiceFetchHandler, Readonly.ReadonlyHandler {

    @EruptField(
            views = @View(title = "颜色", sortable = true),
            edit = @Edit(title = "颜色", search = @Search, type = EditType.COLOR, notNull = true)
    )
    private String color;

    @EruptField(
            views = @View(title = "布尔", sortable = true),
            edit = @Edit(title = "布尔", search = @Search)
    )
    private Boolean bool = true;

    @EruptField(
            views = @View(title = "SQL选择"),
            edit = @Edit(
                    search = @Search,
                    title = "SQL选择", type = EditType.CHOICE, desc = "下拉值为动态获取",
                    choiceType = @ChoiceType(
                            anewFetch = true,
                            fetchHandler = SqlChoiceFetchHandler.class,
//                            dependField = "bool",
//                            dependExpr = "dependValue == vl.value",
                            fetchHandlerParams = {"select id,name from e_upms_menu where type = 'table'", "100000"}
                    ))
    )
    private String sqlChoice;

    @EruptField(
            views = @View(title = "字典项选择"),
            edit = @Edit(
                    search = @Search,
                    title = "字典项选择", type = EditType.CHOICE, desc = "动态获取字典项的值",
                    choiceType = @ChoiceType(
                            fetchHandler = DictCodeChoiceFetchHandler.class,
                            fetchHandlerParams = {"code", "10000"}
                    ))
    )
    private String fromDict;

    @EruptField(
            views = @View(title = "封面图", sortable = true),
            edit = @Edit(title = "封面图", type = EditType.ATTACHMENT, readonly = @Readonly(exprHandler = Complex.class),
                    attachmentType = @AttachmentType(type = AttachmentType.Type.IMAGE, maxLimit = 3))
    )
    private String img;

    @EruptField(
            views = @View(title = "RADIO"),
            edit = @Edit(
                    search = @Search(vague = true),
                    title = "RADIO", type = EditType.CHOICE, desc = "值为动态获取",
                    choiceType = @ChoiceType(
                            anewFetch = true,
                            type = ChoiceType.Type.RADIO,
                            fetchHandler = Complex.class
                    ))
    )
    private String radio;

    @OneToOne(cascade = CascadeType.ALL)
    @EruptField(
            views = @View(title = "扩展表姓名", column = "name"),
            edit = @Edit(title = "扩展表定义", type = EditType.COMBINE)
    )
    private ComplexExt complexExt;


    @Column(length = 10_485_760)
    @EruptField(
            views = @View(title = "Python代码", type = ViewType.CODE),
            edit = @Edit(title = "Python代码编辑器", type = EditType.CODE_EDITOR, codeEditType = @CodeEditorType(language = "python"))
    )
    private String code;

    @ManyToMany
    @JoinTable(
            name = "demo_complex_article",
            joinColumns = @JoinColumn(name = "complex_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"))
    @EruptField(
            views = @View(title = "多对多，关联多篇文章"),
            edit = @Edit(title = "多对多，关联多篇文章", type = EditType.TAB_TABLE_REFER,
                    referenceTableType = @ReferenceTableType(label = "title"))
    )
    private Set<Article> articleTab;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "complex_id")
    @EruptField(
            edit = @Edit(title = "一对多新增", type = EditType.TAB_TABLE_ADD)
    )
    private Set<ComplexTab> complexTab;

    @Override
    public List<VLModel> fetch(String[] params) {
        List<VLModel> list = new ArrayList<>();
        int c = 65;
        for (int i = 0; i < 20; i++) {
            list.add(new VLModel(i + "", (char) (c + i) + " → " + (char) (c + i + 5) + " → " + (char) (c + i + 10), i % 2 == 0));
        }
        return list;
    }

    @Override
    public boolean add(boolean add, String[] params) {
        return true;
    }

    @Override
    public boolean edit(boolean edit, String[] params) {
        return false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
