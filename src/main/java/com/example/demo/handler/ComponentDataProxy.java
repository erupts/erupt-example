package com.example.demo.handler;

import com.example.demo.model.Components;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.DataProxy;

import java.util.Collection;
import java.util.Map;

/**
 * @author liyuepeng
 * @date 2021/1/2 21:29
 */
@Component
public class ComponentDataProxy implements DataProxy<Components> {

    @Override
    public void addBehavior(Components o) {
        o.setInput("China🇨🇳");
        o.setNumber1(3.1415926);
        o.setColor("#0099ff");
    }


    @Override
    public void beforeAdd(Components o) {
        System.err.println("beforeAdd");
    }

    @Override
    public void afterAdd(Components o) {
        System.err.println("afterAdd");
    }

    @Override
    public void beforeUpdate(Components o) {
        System.err.println("beforeUpdate");
    }

    @Override
    public void afterUpdate(Components o) {
        System.err.println("afterUpdate");
    }

    @Override
    public void beforeDelete(Components o) {
        System.err.println("beforeDelete");
    }

    @Override
    public void afterDelete(Components o) {
        System.err.println("afterDelete");
    }

    @Override
    public String beforeFetch() {
        System.err.println("beforeFetch");
        return null;
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {
        System.err.println("afterFetch");
    }

    @Override
    public void editBehavior(Components o) {
        System.err.println("editBehavior");
    }

    @Override
    public void excelExport(Workbook wb) {
        System.err.println("excelExport");
    }

    @Override
    public void excelImport(Components o) {
        System.err.println("excelImport");
    }

}
