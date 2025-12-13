package com.example.demo.model.complex.fun;

import com.example.demo.model.complex.Complex;
import com.example.demo.model.complex.ComplexDialog;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.OperationHandler;
import xyz.erupt.jpa.dao.EruptDao;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @author YuePeng
 * date 2018-10-10.
 */
@Component
public class OperationHandlerImpl implements OperationHandler<Complex, ComplexDialog> {

    @Resource
    private EruptDao eruptDao;

    @Override
    public String exec(List<Complex> data, ComplexDialog complexDialog, String[] param) {
//        throw new EruptWebApiRuntimeException("出错了！！！");
//        return "msg.info('customer hint')";
        return "codeModal('sql',`select * from xxx`)";
    }

    @Override
    public ComplexDialog eruptFormValue(List<Complex> data, ComplexDialog complexDialog, String[] param) {
        complexDialog.setText(data.get(0).getColor());
        complexDialog.setNumber(8L);
        return complexDialog;
    }
}
