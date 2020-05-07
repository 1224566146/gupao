package com.fan.gupao.mvc.action;

import com.fan.gupao.model.Member;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:32 2020/5/7
 */
@RestController
public class MemberAction {

    @GetMapping(value = "/getByName.json")
    @ResponseBody
    public Mono<Member> getByName(@RequestParam String name){
        Member member = new Member();
        member.setName(name);
        return Mono.justOrEmpty(member);
    }

    @GetMapping("/getAll.json")
    @ResponseBody
    public Flux<Member> preview(HttpServletRequest request, HttpServletResponse response){
        return Flux.fromArray(new Member[]{new Member("Tom"),
        new Member("Mic"),
        new Member("James")});
    }

    @PostMapping("/remove.json")
    @ResponseBody
    public Mono<Object> remove(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

    @GetMapping(value = "/edit.json")
    @ResponseBody
    public Flux<Object> edit(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

}
