package com.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.TextFormat;

import java.util.HashMap;

public class SelectBlocks extends Command{
    public SelectBlocks() {
        super("oawrselector");
        this.setDescription("Select blocks for the regener in the Ore&WoodRegener Plugin");
        commandParameters.put("default", new CommandParameter[]{
                new CommandParameter("remove", CommandParamType.STRING, false),
                new CommandParameter("add", CommandParamType.STRING, false)
        });
    }

    public static final HashMap<String, String> runningCommand_oawrselector = new HashMap<String, String>();

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        commandSender.sendMessage("Your parameter is: " + strings[0]);
        if (strings[0].equals("add")) {
            runningCommand_oawrselector.put(commandSender.getName().toString(), "add");
            return false;
        } if (strings[0].equals("remove")){
            runningCommand_oawrselector.put(commandSender.getName().toString(), "remove");
        } else {
            commandSender.sendMessage(TextFormat.RED + "The parameter: " + TextFormat.DARK_RED + strings[0] + TextFormat.RED + " is not a valid argument!");
        }
    return false;
    }
}
