package com.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.command.SelectBlocks;

public class OnJoin extends PlayerEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        SelectBlocks.runningCommand_oawrselector.put(event.getPlayer().getName(), "inactive");
    }
}
