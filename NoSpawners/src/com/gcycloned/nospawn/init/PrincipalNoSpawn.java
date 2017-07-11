package com.gcycloned.nospawn.init;

import com.gcycloned.nospawn.commands.SetWorld;
import com.gcycloned.nospawn.events.SpawnersListener;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class PrincipalNoSpawn extends JavaPlugin
{
    
    public FileConfiguration config = this.getConfig();
    
    @Override
    public void onEnable()
    {
        //Registramos el comando kit
        this.getCommand("nospawners").setExecutor(new SetWorld());
        getServer().getPluginManager().registerEvents(new SpawnersListener(), this);
        getLogger().info("[NoSpawnser] Loading plugin...");
        
        //Revisamos si el config.yml existe
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            getLogger().info("config.yml not found, creating...");
            this.getConfig().set("world", "world");
            this.saveConfig();
        } else {
            getLogger().info("config.yml founded, loading...");
        }
    }

    @Override
    public void onDisable()
    {
        getLogger().info("[NoSpawnser] Disabling plugin...");
    }
}
