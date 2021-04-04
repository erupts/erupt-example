package com.example.demo.action;

import xyz.erupt.annotation.sub_erupt.Tpl;
import xyz.erupt.tpl.annotation.EruptTpl;
import xyz.erupt.tpl.annotation.TplAction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuePeng
 * date 2021/3/30 19:38
 */
@EruptTpl(engine = Tpl.Engine.Velocity)
public class VelocityTplAction {

    @TplAction(value = "velocity.vm", path = "/tpl/velocity/velocity.vm")
    public Map<String, Object> velocity() {
        Map<String, Object> map = new HashMap<>();
        map.put("num", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return map;
    }

}
