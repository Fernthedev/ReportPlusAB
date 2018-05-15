package com.github.fernthedev.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

public class ReportPlusAB extends Plugin {

    private static ReportPlusAB instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info(ChatColor.RED + "BUNGEE IS NOT SUPPORTED AT THIS TIME");
        getProxy().getPluginManager().unregisterCommands(this);
        getProxy().getPluginManager().unregisterListeners(this);
        onDisable();
        //getProxy().getPluginManager().registerListener(this, new ReportNotify());
    }

    @Override
    public void onDisable() {
        instance = null;
        getProxy().getPluginManager().unregisterListeners(this);
    }

    public static ReportPlusAB getInstance() {
        return instance;
    }
}
