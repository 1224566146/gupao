package com.fan.gupao;

import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:36 2020/5/7
 */
public class WebClientTest {


    @Test
    public void webClientTest() throws InterruptedException {
        WebClient webClient = WebClient.create("http://localhost:80");
        Mono<String> resp = webClient
                .get().uri("/getAll.json")
                .retrieve()
                .bodyToMono(String.class);
        System.out.println(resp);
        resp.subscribe(System.out::println);
        TimeUnit.SECONDS.sleep(1);
    }
}
