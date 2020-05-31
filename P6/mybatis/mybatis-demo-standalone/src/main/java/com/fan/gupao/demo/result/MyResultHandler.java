package com.fan.gupao.demo.result;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 对返回的结果进行处理，最终得到自己想要的数据格式或类型
 * 可以自定义返回类型，在接口方法中传入，不需要定义
 * @Author: 樊高风
 * @Date: 17:45 2020/5/8
 */
public class MyResultHandler implements ResultHandler {

    private final Map mappedResults = new HashMap();

    @Override
    public void handleResult(ResultContext resultContext) {
        Map map = (Map)resultContext.getResultObject();
        mappedResults.put(map.get("key"), map.get("value"));
    }

    public Map getMappedResults() {
        return mappedResults;
    }
}
