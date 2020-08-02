package com.fan.gupao.demo.clients;

import com.fan.gupao.demo.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@FeignClient(value = "user-service")
public interface IUserAuthFeignClient {


    @GetMapping(value = "/token",consumes = MediaType.APPLICATION_JSON_VALUE)
    R<String> validToken(@RequestParam("token")String token);
}
