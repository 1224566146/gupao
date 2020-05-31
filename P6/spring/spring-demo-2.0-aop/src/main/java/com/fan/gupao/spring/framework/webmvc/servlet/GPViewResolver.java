package com.fan.gupao.spring.framework.webmvc.servlet;

import java.io.File;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 14:52 2020/4/13
 */
public class GPViewResolver {

    private final String DEFAULT_TEMPLATE_SUFFIX = ".html";

    private File templateRootDir;

    public GPViewResolver(String templateRoot) {
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        templateRootDir = new File(templateRootPath);
    }

    public GPView resolveViewName(String viewName){

        if(null == viewName || "".equals(viewName.trim())){
            return null;
        }

        viewName =viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX)?viewName:(viewName+DEFAULT_TEMPLATE_SUFFIX);
        File templateFile = new File((templateRootDir.getPath()+"/"+viewName).replaceAll("/+", "/"));

        return new GPView(templateFile);

    }

}
