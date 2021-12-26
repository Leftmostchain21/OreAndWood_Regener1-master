package com.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerToggleSneakEvent;
import cn.nukkit.utils.TextFormat;
import com.command.SelectBlocks;

public class IsSneaking implements Listener {

    @EventHandler
    public void isSneaking(PlayerToggleSneakEvent event) {
        if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "add") {
            event.getPlayer().sendMessage(TextFormat.GOLD + "You have now disable you OAWR Selector!");
            SelectBlocks.runningCommand_oawrselector.put(event.getPlayer().getName(), "inactive");
        }
        if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "remove") {
            event.getPlayer().sendMessage(TextFormat.GOLD + "You have now disable you OAWR Selector!");
            SelectBlocks.runningCommand_oawrselector.put(event.getPlayer().getName(), "inactive");
        }
        if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "bypass") {
            event.getPlayer().sendMessage(TextFormat.GOLD + "You have now disable you OAWR Selector!");
            SelectBlocks.runningCommand_oawrselector.put(event.getPlayer().getName(), "inactive");
        }
    }
}