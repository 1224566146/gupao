package com.fan.gupao.demo.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

/**
 * @author 樊高风
 * @date 2020/8/8
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus,OrderStatusChangeEvent> {


    /**
     * 功能描述: 配置状态
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/8 17:18
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states) throws Exception {
       states
               .withStates()
               .initial(OrderStatus.WAIT_PAYMENT)
               .states(EnumSet.allOf(OrderStatus.class));
    }

    /**
     * 功能描述: 配置状态转换事件关系
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/8 17:18
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions) throws Exception {
        transitions
                .withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                .withExternal().source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }

    /**
     * 功能描述: 持久化配置
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/8 17:22
     */
    @Bean
    public DefaultStateMachinePersister persister(){
        return new DefaultStateMachinePersister(new StateMachinePersist<Object,Object,Order>() {


            @Override
            public void write(StateMachineContext<Object, Object> stateMachineContext, Order order) throws Exception {
                // 此处并没有进行持久化操作
            }

            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                // 此处直接获取order中的状态,其实并没有进行持久化读取操作
                return new DefaultStateMachineContext<>(order.getStatus(), null, null, null);
            }
        });
    }
}
