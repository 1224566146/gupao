package com.fan.gupao.demo.player;

import com.fan.gupao.demo.player.actions.PauseAction;
import com.fan.gupao.demo.player.actions.PlayAction;
import com.fan.gupao.demo.player.actions.SpeedAction;
import com.fan.gupao.demo.player.actions.StopAction;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class Test {

    public static void main(String[] args) {

        GPlayer player = new GPlayer();
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));


        controller.addAction(new PauseAction(player));
        controller.addAction(new PlayAction(player));
        controller.addAction(new StopAction(player));
        controller.addAction(new SpeedAction(player));

        controller.executes();
    }

}
