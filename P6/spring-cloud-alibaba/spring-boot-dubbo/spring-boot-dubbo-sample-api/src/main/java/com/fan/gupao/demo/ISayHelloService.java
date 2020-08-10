package com.fan.gupao.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author 樊高风
 * @date 2020/8/7
 */
@Path("/")
public interface ISayHelloService {

    @GET
    @Path("/say")
    String sayHello(String msg);

}
