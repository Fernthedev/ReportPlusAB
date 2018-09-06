package com.github.fernthedev.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

public class ReportPlusAB extends Plugin {

    private static ReportPlusAB instance;

    public static String versionNumber;


    @Override
    public void onEnable() {
        instance = this;
       // getLogger().info(ChatColor.RED + "BUNGEE IS NOT SUPPORTED AT THIS TIME");
        getLogger().info("Reportplus for advancedban has now been enabled.");
        getProxy().getPluginManager().registerListener(this, new ReportNotify());

        versionNumber = getDescription().getVersion();

        //getProxy().getPluginManager().unregisterCommands(this);
        //getProxy().getPluginManager().unregisterListeners(this);
       // ProxyServer.getInstance().getPluginManager().getPlugin("ReportPlusAB").onDisable();
        //
    }




    @Override
    public void onDisable() {
        instance = null;
        getProxy().getPluginManager().unregisterListeners(this);
        getLogger().info(ChatColor.GREEN + "Successfully disabled plugin");
    }

    static ReportPlusAB getInstance() {
        return instance;
    }
}
