package com.fan.gupao.spring.framework.webmvc.servlet;

import java.util.Map;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:44 2020/4/27
 */
public class GPModelAndView {

    private String viewName;

    private Map<String,?> model;

    public GPModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public GPModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
