package com.example.demo.handler;

import com.example.demo.model.Complex;
import com.example.demo.model.ComplexOperator;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.OperationHandler;
import xyz.erupt.core.exception.EruptApiErrorTip;
import xyz.erupt.core.view.EruptApiModel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liyuepeng
 * date 2018-10-10.
 */
@Component
public class OperationHandlerImpl2 implements OperationHandler<Complex, ComplexOperator> {

    @Resource
    private HttpServletRequest request; //展示自动注入功能

    @Override
    public String exec(List<Complex> data, ComplexOperator complexOperator, String[] param) {
        System.out.println(OperationHandlerImpl2.class.getSimpleName());
        System.out.println(data);
        return null;
    }

}
