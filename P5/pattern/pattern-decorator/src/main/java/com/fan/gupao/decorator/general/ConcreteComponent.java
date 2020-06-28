package com.fan.gupao.decorator.general;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        // 相应的功能处理
        System.out.println("处理业务逻辑");
    }
}
