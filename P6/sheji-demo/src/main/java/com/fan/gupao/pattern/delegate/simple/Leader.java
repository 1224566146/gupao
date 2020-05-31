package com.fan.gupao.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:38 2020/3/4
 */
public class Leader implements IEmployee {

    private Map<String,IEmployee> targets = new HashMap<>();

    public Leader(){
        targets.put("加密", new EmployeeA());
        targets.put("架构", new EmployeeB());
    }

    //项目经理自己不干活
    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
