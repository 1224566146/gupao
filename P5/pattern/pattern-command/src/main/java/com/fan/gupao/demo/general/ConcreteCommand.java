package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
// 具体命令
public class ConcreteCommand implements ICommand {

    // 直接创建接收者,不暴露给客户端
    private Receiver mReceiver = new Receiver();

    @Override
    public void execute() {
        this.mReceiver.action();
    }
}
