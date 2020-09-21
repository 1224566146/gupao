package com.fan.gupao.demo.springbootsentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootSentinelApplication {

    public static void main(String[] args) {
        initFlowRule();
        SpringApplication.run(SpringbootSentinelApplication.class, args);
    }

    private static void initFlowRule(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        // 针对哪个资源设置规则
        flowRule.setResource("doTest");
        // QPS或者并发数
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(5);
        rules.add(flowRule);
        FlowRuleManager.loadRules(rules);
    }
}
