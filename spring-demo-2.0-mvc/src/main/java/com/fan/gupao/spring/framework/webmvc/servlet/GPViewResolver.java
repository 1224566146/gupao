package com.fan.gupao.spring.framework.webmvc.servlet;

import java.io.File;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:38 2020/4/11
 */
public class GPViewResolver {

    private final String DEFAULT_TEMPLATE_SUFFIX = ".html";

    private File tempateRootDir;

    public GPViewResolver(String tempateRootDir) {
        String templateRootPath = this.getClass().getClassLoader().getResource(tempateRootDir).getFile();
        this.tempateRootDir = new File(templateRootPath);
    }

    public GPView resolveViewName(String viewName) {

        if(null == viewName || "".equals(viewName.trim())){
            return null;
        }
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX)?viewName : (viewName+DEFAULT_TEMPLATE_SUFFIX);
        File templateFile = new File((tempateRootDir.getPath()+"/"+viewName).replaceAll("/+", "/"));
        return new GPView(templateFile);
    }
}
