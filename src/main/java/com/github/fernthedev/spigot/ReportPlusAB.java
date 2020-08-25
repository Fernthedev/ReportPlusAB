package com.github.fernthedev.spigot;

import com.github.fernthedev.Universal.EnabledClasses;
import com.github.fernthedev.Universal.LitebansClassLoader;
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

        // getLogger().info(ChatColor.RED + "BUNGEE IS NOT SUPPORTED AT THIS TIME");
        if (getServer().getPluginManager().getPlugin("LiteBans") != null)
            EnabledClasses.whichPunishment = EnabledClasses.WhichBan.LITEBANS;
        else if (getServer().getPluginManager().getPlugin("AdvancedBan") != null)
            EnabledClasses.whichPunishment = EnabledClasses.WhichBan.ADVANCEDBAN;
        else EnabledClasses.whichPunishment = null;

        versionNumber = getDescription().getVersion();

        if (EnabledClasses.whichPunishment == null) {
            getLogger().warning("No compatible punishment system running, closing");
            getLogger().warning("Currently supported punishment systems are AdvancedBan and LiteBans.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        if(EnabledClasses.whichPunishment == EnabledClasses.WhichBan.ADVANCEDBAN) {
            getServer().getPluginManager().registerEvents(new AdvancedBanNotify(), this);
        }

        if (EnabledClasses.whichPunishment == EnabledClasses.WhichBan.LITEBANS) {
            LitebansClassLoader.registerLitebans(new LitebansNotify());
        }
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
