package com.github.fernthedev.spigot;

import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ReportPlusAB extends JavaPlugin {

    private static ReportPlusAB instance;

    public static String versionNumber;


    private Configuration config;

    @Override
    public void onEnable() {
        instance = this;
        versionNumber = getDescription().getVersion();
        getServer().getPluginManager().registerEvents(new ReportNotify(),this);

    }





    @Override
    public void onDisable() {
        instance = null;
        getLogger().info(ChatColor.RED + "SHUTTING DOWN ;w;");
    }


    static ReportPlusAB getInstance() {
        return instance;
    }
}
