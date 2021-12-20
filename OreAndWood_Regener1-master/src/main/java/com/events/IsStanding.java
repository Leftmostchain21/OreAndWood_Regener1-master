package com.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerToggleSneakEvent;

import java.util.HashMap;

public class IsStanding implements Listener {
    @EventHandler
    public void isStanding(PlayerToggleSneakEvent event){
        HashMap<String, Boolean> isStanding = new HashMap<String, Boolean>();
        isStanding.put(event.getPlayer().getName(), false);
    return;}
}
