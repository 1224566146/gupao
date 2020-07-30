package com.fan.gupao.demo.player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class Controller {

    private List<IAction> actions = new ArrayList<>();

    public void addAction(IAction action){
        actions.add(action);
    }

    public void execute(IAction action){
        action.execute();
    }

    public void executes(){
        for (IAction action : actions) {
            action.execute();
        }
        actions.clear();
    }

}
