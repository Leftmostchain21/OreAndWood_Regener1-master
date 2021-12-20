package com.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerToggleSneakEvent;
import com.command.SelectBlocks;

public class IsSneaking implements Listener {

    @EventHandler
    public void isSneaking(PlayerToggleSneakEvent event){
        SelectBlocks.runningCommand_oawrselector.put(event.getPlayer().getName(), "inactive");
        }
    }