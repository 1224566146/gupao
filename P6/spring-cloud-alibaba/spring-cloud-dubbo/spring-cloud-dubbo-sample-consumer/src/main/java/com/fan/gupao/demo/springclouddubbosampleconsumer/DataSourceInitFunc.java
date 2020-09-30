package com.fan.gupao.demo.springclouddubbosampleconsumer;

import com.alibaba.csp.sentinel.adapter.dubbo.config.DubboAdapterGlobalConfig;
import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DubboFallback;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.apache.dubbo.rpc.AsyncRpcResult;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/9/30
 */
public class DataSourceInitFunc implements InitFunc {
    @Override
    public void init() throws Exception {
        loadDegradeRule();
        registerFallback();
    }

    private void loadDegradeRule(){
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        // 表示针对哪个服务或者方法的熔断
        rule.setResource("com.fan.gupao.demo.ISayHelloService");
        // 指标
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        // 阈值
        rule.setCount(3);
        // 100s
        rule.setTimeWindow(100);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }


    private void registerFallback(){
        DubboAdapterGlobalConfig.setConsumerFallback(new DubboFallback() {
            @Override
            public Result handle(Invoker<?> invoker, Invocation invocation, BlockException e) {
                AsyncRpcResult arr = new AsyncRpcResult(null,invocation);
                arr.setException(e.getCause());
                return arr;
            }
        });
    }
}
