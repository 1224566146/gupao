package com.fan.gupao.demo.sourceloader;

import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author 樊高风
 * @date 2020/7/16
 */
public class GpDefineJsonProperySource extends EnumerablePropertySource<Map<String, Object>> {
    public GpDefineJsonProperySource(String name, Map<String, Object> source) {
        super(name, source);
    }

    @Override
    public String[] getPropertyNames() {
        return StringUtils.toStringArray(this.source.keySet());
    }

    @Override
    public Object getProperty(String name) {
        return this.source.get(name);
    }
}
