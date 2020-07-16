package com.fan.gupao.demo.sourceloader;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 樊高风
 * @date 2020/7/16
 * springboot中提供的一个属性文件的扩展接口(spring boot启动的过程中会触发调用)
 */
public class JsonProperySourceLocator implements PropertySourceLocator {

    private static final String DEFAULT_LOCATION = "classpath:gupao.json";

    private final ResourceLoader resourceLoader = new DefaultResourceLoader(getClass().getClassLoader());


    @Override
    public PropertySource<?> locate(Environment environment) {
        GpDefineJsonProperySource jsonProperySource =
                new GpDefineJsonProperySource("jsonPropertyConfig", mapPropertySource());
        return jsonProperySource;
    }

    private Map<String, Object> mapPropertySource() {
        // 访问远程配置?http接口。
        Resource resource = this.resourceLoader.getResource(DEFAULT_LOCATION);
        if (resource == null) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> fileMap = jsonParser.parseMap(readFile(resource));
        processorMap("",result,fileMap);
        return result;
    }

    private void processorMap(String prefix, Map<String, Object> result, Map<String, Object> fileMap) {
        if(prefix.length()>0){
            prefix+=".";
        }
        for (Map.Entry<String, Object> entry : fileMap.entrySet()) {
            if(entry.getValue() instanceof  Map){
                processorMap(prefix+entry.getKey(), result, (Map<String,Object>)entry.getValue());
            }else{
                result.put(prefix+entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 功能描述: 读取配置文件
     *
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/7/16 17:30
     */
    private String readFile(Resource resource) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(resource.getFile());
            byte[] readByte = new byte[(int) resource.getFile().length()]; // TODO 错误演示
            fileInputStream.read(readByte);
            return new String(readByte, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
