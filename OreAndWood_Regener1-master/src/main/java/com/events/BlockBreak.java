package com.events;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockCobblestone;
import cn.nukkit.block.BlockStone;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
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
        if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "add") {
            File f = new File("/home/thomas/nukkitServers/firstTesting/plugins/OreAndWoodRegenerData/OreAndWoodRegenerData.txt");     //Creation of File Descriptor for input file
            FileReader fr = new FileReader(f);   //Creation of File Reader object
            BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
            String storedBlock;
            boolean blockAlreadyExists = false;
            while ((storedBlock = br.readLine()) != null)       //Reading the content line by line
            {
                if (locationOfBlock.equals(storedBlock)) {
                    event.getPlayer().sendMessage(TextFormat.RED + "Sorry, " + TextFormat.DARK_RED + locationOfBlock + TextFormat.RED + " is already being a generated block!");
                    blockAlreadyExists = true;
                }
            }
            fr.close();
            if (!blockAlreadyExists) {
                FileWriter fw = new FileWriter(f, true);  //Create filewriter object for the file descriptor with append options set as true
                fw.append("\n").append(locationOfBlock);  //Append the Content
                fw.flush();
                fw.close();
            }
            event.setCancelled();
        }
        else if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "remove") {
            Path path = Paths.get("/home/thomas/nukkitServers/firstTesting/plugins/OreAndWoodRegenerData/OreAndWoodRegenerData.txt");
            String charset = "UTF-8";
            boolean blockAlreadyExists = true;
            String delete = locationOfBlock;
            Stream<String> lines = Files.lines(path);
            List<String> originalList = lines.collect(Collectors.toList());
            List<String> replaced = originalList.stream().map(line -> line.replaceAll(locationOfBlock, "")).collect(Collectors.toList());
            boolean isLocationOfBlockIn = originalList.stream().anyMatch(s -> s.contains(locationOfBlock));
            Files.write(path, replaced);
            lines.close();
            if (isLocationOfBlockIn) {
                blockAlreadyExists = false;
                event.getPlayer().sendMessage(TextFormat.GREEN + "Block @ " + TextFormat.DARK_GREEN + locationOfBlock + TextFormat.GREEN + " was successfully removed!");
            }
            if (blockAlreadyExists) {
                event.getPlayer().sendMessage(TextFormat.RED + "Sorry, " + TextFormat.DARK_RED + locationOfBlock + TextFormat.RED + " is already not being a generated block!");
            }
            event.setCancelled();
        }
//        if (event.getPlayer().hasPermission("group.admin")){
//
//            }
        else if (Core.getBreakableBlocks().contains(locationOfBlock)) {
//            if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "add") {
//                event.setCancelled();
//                }
//            if (SelectBlocks.runningCommand_oawrselector.get(event.getPlayer().getName()) == "remove") {
//                event.setCancelled();
//                }
            Vector3 locoOfBlockToReplace = event.getBlock().getLocation();
            if(event.getBlock().getId() == 1){
                event.getPlayer().getLevel().setBlock(locoOfBlockToReplace, Block.get(Block.COBBLESTONE));
                }
            }
        else {
            event.setCancelled();
            }
        }
    }