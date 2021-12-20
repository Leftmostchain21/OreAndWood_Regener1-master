package com.oreandtreesgen;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.TextFormat;
import com.command.SelectBlocks;
import com.events.BlockBreak;
import com.events.IsSneaking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Core extends PluginBase {

    public static Core plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info(TextFormat.GREEN + "\n\nPlugin is enabled!\n\n");
        registerCommands();
        registerEvents();
    }

    public List<String> getBreakableBlocks() throws FileNotFoundException {
        //////////Selecting blocks////////////

        String[] breakableBlockss = new String[0];

        FileReader fileReader = new FileReader("/home/thomas/nukkitServers/firstTesting/plugins/OreAndWoodRegenerData/OreAndWoodRegenerData.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String breakableBlock = null;

        List<String> breakableBlocks = Arrays.asList(breakableBlockss);

        while (true) {
            try {
                if (!((breakableBlock = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            breakableBlocks.add(breakableBlock);
        }
        return breakableBlocks;
    }

    private void registerCommands() {
        this.getServer().getCommandMap().register("oawrs", new SelectBlocks());
    }

    private void registerEvents(){
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BlockBreak(),this);
        pluginManager.registerEvents(new IsSneaking(), this);
    }

}
