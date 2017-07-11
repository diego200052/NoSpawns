package com.gcycloned.nospawn.events;

import com.gcycloned.nospawn.init.PrincipalNoSpawn;
import org.bukkit.Bukkit;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.plugin.Plugin;


public class SpawnersListener implements Listener
{
    Plugin plugin = ((PrincipalNoSpawn)Bukkit.getPluginManager().getPlugin("NoSpawners"));
    
    @EventHandler
    public void onMobSpawns(SpawnerSpawnEvent event)
    {
        String worldName = plugin.getConfig().getString("world");
        String worldCompareName = "CraftWorld{name=" + worldName + "}";
        if(event.getLocation().getWorld().getName().equals(worldCompareName) || event.getLocation().getWorld().getName().equals(worldName))
        {
            //Remove the Mob spawner
            if(event.getSpawner().getBlock() != null)
                event.getSpawner().getBlock().breakNaturally();
            //Cancels event
            event.setCancelled(true);
        }
    }
}
