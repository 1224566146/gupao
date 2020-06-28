package com.fan.gupao.decorator.general;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class ConcreteDecoratorA extends Decorator {
    /**
     * 功能描述: 构造方法,传入组件对象
     *
     * @param component 组件对象
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/6/28 17:20
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    private void operationFirst(){}  // 在调用父类的operation方法之前需要执行的操作
    private void operationLast(){} // 在调用父类的operation方法之后需要执行的操作

    @Override
    public void operation() {
        // 调用父类的方法,可以在调用前后执行一些附加动作
        operationFirst();
        super.operation(); // 这里可以选择性的调用父类的方法,如果不调用则相当于完全改写了方法,实现了新的功能
        operationLast();
    }
}
