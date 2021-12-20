package com.events;

import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.utils.TextFormat;
import com.command.SelectBlocks;
import com.oreandtreesgen.Core;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) throws IOException {
        double locationOfBlockX = event.getBlock().getLocation().getX();
        double locationOfBlockY = event.getBlock().getLocation().getY();
        double locationOfBlockZ = event.getBlock().getLocation().getZ();
        String locationOfBlock = "" + locationOfBlockX + "," + locationOfBlockY + "," + locationOfBlockZ;
        Block block = event.getBlock().getLevelBlock();
        event.getPlayer().sendMessage("you broke a block at " + locationOfBlock);
        event.getPlayer().sendMessage("crouching state" + SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()));
        if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "add") {
            File f = new File("/home/thomas/nukkitServers/firstTesting/plugins/OreAndWoodRegenerData/OreAndWoodRegenerData.txt");     //Creation of File Descriptor for input file
            FileReader fr = new FileReader(f);   //Creation of File Reader object
            BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
            String storedBlock;
            event.getPlayer().sendMessage("well hello");
            boolean blockAlreadyExists = false;
            while ((storedBlock = br.readLine()) != null)       //Reading the content line by line
            {
                if (locationOfBlock.equals(storedBlock)) {
                    event.getPlayer().sendMessage(TextFormat.RED + "Sorry," + TextFormat.DARK_RED + locationOfBlock + TextFormat.RED + "is already being a generated block!");
                    blockAlreadyExists = true;
                }
            }
            fr.close();
            if (!blockAlreadyExists) {
                event.getPlayer().sendMessage("howdy there!");
                FileWriter fw = new FileWriter(f, true);  //Create filewriter object for the file descriptor with append options set as true
                fw.append("\n").append(locationOfBlock);  //Append the Content
                fw.flush();
                fw.close();
            }
            event.setCancelled();
        }
        if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "remove") {
            Path path = Paths.get("/home/thomas/nukkitServers/firstTesting/plugins/OreAndWoodRegenerData/OreAndWoodRegenerData.txt");
            String charset = "UTF-8";
            boolean blockAlreadyExists = true;
            String delete = locationOfBlock;
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines.map(line -> line.replaceAll(locationOfBlock, "")).collect(Collectors.toList());
            boolean isLocationOfBlockIn = lines.anyMatch(s -> s.contains(locationOfBlock));
            Files.write(path, replaced);
            lines.close();
            event.getPlayer().sendMessage("yellop");
            if (isLocationOfBlockIn) {
                event.getPlayer().sendMessage("c3po");
                blockAlreadyExists = false;
                event.getPlayer().sendMessage(TextFormat.GREEN + "Block @ " + TextFormat.DARK_GREEN + locationOfBlock + TextFormat.GREEN + " was successfully removed!");
            }
            event.setCancelled();
            if (blockAlreadyExists) {
                event.getPlayer().sendMessage(TextFormat.RED + "Sorry, " + TextFormat.DARK_RED + locationOfBlock + TextFormat.RED + " is already not being a generated block!");
            }
            event.setCancelled();
            if (Core.plugin.getBreakableBlocks().contains(locationOfBlock)) {
                event.getPlayer().sendMessage("aadfa");
             else {
                event.setCancelled();
                event.getPlayer().sendMessage("2w43563");
            }
        }
    }
}