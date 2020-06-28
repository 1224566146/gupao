package com.fan.gupao.decorator.general;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public abstract class Decorator extends Component {

    /**
     * 功能描述: 持有组件对象
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/6/28 17:20
     */
    protected Component component;

    /**
     * 功能描述: 构造方法,传入组件对象
     * @param component 组件对象
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/6/28 17:20
     */
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        // 转发请求给组件对象,可以在转发前后执行一些附加动作
        component.operation();
    }
}
