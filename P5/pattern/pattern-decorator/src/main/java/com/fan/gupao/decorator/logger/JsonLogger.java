package com.fan.gupao.decorator.logger;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class JsonLogger extends LoggerDecorator {
    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String msg) {
        JSONObject result = newJsonObject();
        result.put("message",msg);
        logger.info(result.toString());
    }

    @Override
    public void error(String msg) {
        JSONObject result = newJsonObject();
        result.put("message",msg);
        logger.error(result.toString());
    }

    public void error(Exception e){
        JSONObject result = newJsonObject();
        result.put("exception", e.getClass().getName());
        String trace = Arrays.toString(e.getStackTrace());
        result.put("starckTrace", trace);
        logger.error(result.toString());
    }

    private JSONObject newJsonObject(){
        return new JSONObject();
    }
}
