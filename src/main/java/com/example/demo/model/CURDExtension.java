package com.example.demo.model;

import com.example.demo.test.BaseModel;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.core.exception.EruptApiErrorTip;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Map;

/**
 * @author YuePeng
 * date 2021/5/11 13:56
 * see <a href="https://www.yuque.com/erupts/erupt/nicqg3">link</a>
 */
@Erupt(
        name = "DataProxy 简单实用",
        desc = "服务层逻辑扩展 @DataProxy （扩展CURD）",
        dataProxy = CURDExtension.class
)
@Entity
@Table(name = "demo_curd_extension")
public class CURDExtension extends BaseModel implements DataProxy<CURDExtension> {

    @EruptField(
            views = @View(title = "名称"),
            edit = @Edit(title = "名称", notNull = true, search = @Search(vague = true))
    )
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void beforeAdd(CURDExtension curdExtension) {
        //字段校验
        if ("张三".equals(curdExtension.getName())) {
            throw new EruptApiErrorTip("名称禁止为张三！");
        }
    }

    @Override
    public void afterAdd(CURDExtension curdExtension) {
        //TODO 添加完成后处理逻辑
    }

    @Override
    public void beforeUpdate(CURDExtension curdExtension) {
        //动态写数据
        curdExtension.setName(curdExtension.getName() + "xxx");
    }

    @Override
    public void afterUpdate(CURDExtension curdExtension) {
        //TODO 修改完成后处理逻辑
    }

    @Override
    public void beforeDelete(CURDExtension curdExtension) {
        //TODO 删除前事件处理逻辑
    }

    @Override
    public void afterDelete(CURDExtension curdExtension) {
        //TODO 删除后事件处理逻辑
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {
        //TODO 查询结果处理
    }

    @Override
    public void addBehavior(CURDExtension curdExtension) {
        //TODO 数据初始化逻辑
    }

    @Override
    public void editBehavior(CURDExtension curdExtension) {
        //TODO 编辑时数据处理逻辑
    }
}
