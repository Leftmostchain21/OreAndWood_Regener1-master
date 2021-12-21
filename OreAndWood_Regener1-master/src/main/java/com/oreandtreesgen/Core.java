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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Core extends PluginBase {

    public static Core plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info(TextFormat.GREEN + "\n\nPlugin is enabled!\n\n");
        registerCommands();
        registerEvents();
    }

    public static List<String> getBreakableBlocks() throws IOException {
        //////////Selecting blocks////////////
        Path path = Paths.get("/home/thomas/nukkitServers/firstTesting/plugins/OreAndWoodRegenerData/OreAndWoodRegenerData.txt");
        Stream<String> lines = Files.lines(path);
        List<String> originalList = lines.collect(Collectors.toList());
        return originalList;
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
