package com.example.demo.model;

import xyz.erupt.annotation.fun.OperationHandler;

import java.util.List;

/**
 * @author yuepeng
 * @date 2020/12/28 11:59
 */
public class OperationHandlerImpl implements OperationHandler<DemoHyper, Void> {

    @Override
    public void exec(List<DemoHyper> data, Void unused, String[] param) {
        System.err.println("按钮方法执行成功！");
    }

}
