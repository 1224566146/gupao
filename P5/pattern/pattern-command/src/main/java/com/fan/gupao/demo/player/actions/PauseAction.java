package com.fan.gupao.demo.player.actions;

import com.fan.gupao.demo.player.GPlayer;
import com.fan.gupao.demo.player.IAction;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class PauseAction implements IAction {

    private GPlayer player;

    public PauseAction(GPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}
