package com.github.fernthedev.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class ReportPlusAB extends JavaPlugin {

    private static ReportPlusAB instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new ReportNotify(),this);
    }




    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("SHUTTING DOWN ;W;");
    }

    static ReportPlusAB getInstance() {
        return instance;
    }
}
