package com.example.demo.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.sub_erupt.RowOperation;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Map;

/**
 * @author yuepeng
 * @date 2020/12/28 11:47
 */
@Entity
@Table(name = "demo_hyper")
@Erupt(
        name = "超级示例",
        dataProxy = {DemoHyper.class},  //增删改查等行为数据代理
        rowOperation = {                //自定义按钮
                @RowOperation(title = "多行操作", code = "MULTI", icon = "fa fa-check-square",
                        operationHandler = OperationHandlerImpl.class),
                @RowOperation(title = "按钮操作", code = "BUTTON", tip = "不依赖任何数据即可执行", icon = "fa fa-google-wallet",
                        operationHandler = OperationHandlerImpl.class, mode = RowOperation.Mode.BUTTON),
        }
)
//继承 HyperModel 就可以让 erupt 帮助管理，创建人，修改人，创建时间，修改时间
public class DemoHyper extends HyperModel implements DataProxy<DemoHyper> {

    @EruptField(
            views = @View(title = "文本"),
            edit = @Edit(title = "文本", notNull = true, search = @Search)
    )
    private String input;

    @Override
    public void beforeAdd(DemoHyper demoHyper) {
        System.out.println("新增前");
    }

    @Override
    public void afterAdd(DemoHyper demoHyper) {
        System.out.println("新增后");
    }

    @Override
    public void beforeUpdate(DemoHyper demoHyper) {
        System.out.println("更新后");
    }

    @Override
    public void afterUpdate(DemoHyper demoHyper) {
        System.out.println("更新后");
    }

    @Override
    public void beforeDelete(DemoHyper demoHyper) {
        System.out.println("删除前");
    }

    @Override
    public void afterDelete(DemoHyper demoHyper) {
        System.out.println("删除后");
    }

    @Override
    public String beforeFetch() {
        System.out.println("查询前自定义条件");
        return null;
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {
        System.out.println("查询后结果处理");
    }

    @Override
    public void addBehavior(DemoHyper demoHyper) {
        System.out.println("数据新增行为，可对数据做初始化等操作");
    }

    @Override
    public void editBehavior(DemoHyper demoHyper) {
        System.out.println("数据编辑行为，对待编辑的数据做预处理");
    }
}
