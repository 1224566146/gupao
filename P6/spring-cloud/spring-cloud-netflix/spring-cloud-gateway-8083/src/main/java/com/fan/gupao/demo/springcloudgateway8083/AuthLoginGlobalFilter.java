package com.fan.gupao.demo.springcloudgateway8083;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.clients.IUserAuthFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@Slf4j
@PropertySource(value = "classpath:loginfilter.properties")
@Component
public class AuthLoginGlobalFilter implements GlobalFilter, Ordered {

    @Value("#{'${jwt.ignoreUrls}'.split(',')}")
    List<String> ignoreUrls;

    @Autowired
    IUserAuthFeignClient userAuthFeignClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (ignoreUrls != null && ignoreUrls.contains(request.getURI().getPath())) {
            return chain.filter(exchange);
        }
        String access_token = request.getHeaders().getFirst("access_token");
        if (StringUtils.isBlank(access_token)) {
            return onError(exchange, "尚未登录");
        }
        R<String> r = userAuthFeignClient.validToken(access_token);
        if (r.getCode() == 200) {
            ServerHttpRequest shr = request.mutate().header("uid", r.getData()).build();
            return chain.filter(exchange.mutate().request(shr).build());
        }
        return onError(exchange, r.getMsg());
    }

    private Mono<Void> onError(ServerWebExchange exchange, String msg) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        R rd = new R.Builder<>().buildCustomize(HttpStatus.UNAUTHORIZED.value(), msg);
        ObjectMapper objectMapper = new ObjectMapper();
        String rs = "";
        try {
            rs = objectMapper.writeValueAsString(rd);
        } catch (JsonProcessingException e) {
            log.error("occur Exception:" + e);
        }
        DataBuffer buffer = response.bufferFactory().wrap(rs.getBytes());
        return response.writeWith(Flux.just(buffer));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
