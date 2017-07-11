/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcycloned.nospawn.commands;

import com.gcycloned.nospawn.init.PrincipalNoSpawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class SetWorld implements CommandExecutor
{
    Plugin plugin = ((PrincipalNoSpawn)Bukkit.getPluginManager().getPlugin("NoSpawners"));
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args)
    {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            World world = player.getWorld();
            if(player.hasPermission("nospawns.admin"))
            {
                String worldName = world.getName();
                worldName = worldName.replace("CraftWorld{name=", "");
                worldName = worldName.replace("}", "");
                player.sendMessage(ChatColor.GREEN + "World: " + ChatColor.BLUE +worldName + ChatColor.GREEN + ", now when mob spawns from a spawner the spawner and mob get destroyed.");
                plugin.getConfig().set("world", worldName);
                plugin.saveConfig();
            }
            else
            {
                player.sendMessage("" + ChatColor.DARK_RED + "You dont have permissions to use this command.");
            }
        }
        else
        {
            System.out.println("This command only works in-game.");
        }
        return true;
    }
}
