package com.example.demo.model.complex.fun;

import com.example.demo.model.complex.Complex;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.model.Column;
import xyz.erupt.annotation.model.Row;
import xyz.erupt.annotation.query.Condition;

import java.util.*;

/**
 * @author YuePeng
 * date 2023/4/11 23:31
 */
public class ComplexDataProxy implements DataProxy<Complex> {

    @Override
    public void afterAdd(Complex complex) {
        System.out.println(complex);
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {
        DataProxy.super.afterFetch(list);
    }

    @Override
    public List<Row> extraRow(List<Condition> conditions) {
        List<Row> rows = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        columns.add(Column.builder().value("自定义行").colspan(2).build());
        columns.add(Column.builder().value(100 + "").colspan(10).className("text-red").build());
        rows.add(Row.builder().columns(columns).build());
        return rows;
    }

    @Override
    public void editBehavior(Complex complex) {
        complex.setCode("xxx");
    }
}
