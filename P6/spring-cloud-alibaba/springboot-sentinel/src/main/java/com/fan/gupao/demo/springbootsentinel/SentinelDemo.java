package com.fan.gupao.demo.springbootsentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/9/21
 */
public class SentinelDemo {


    public static void main(String[] args) {
        // 初始化限流规则
        initFlowRule();
        while (true){
            // ResourceName表示资源,控制访问流量的点
            try (Entry entry =SphU.entry("helloWorld")){
                System.out.println("helloWorld");
            } catch (BlockException e) {
                System.out.println("被拒绝");
            }
        }


    }

    private static void initFlowRule(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        // 针对哪个资源设置规则
        flowRule.setResource("helloWorld");
        // QPS或者并发数
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(5);
        rules.add(flowRule);
        FlowRuleManager.loadRules(rules);
    }
}
