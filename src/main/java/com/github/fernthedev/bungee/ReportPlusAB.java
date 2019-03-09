package com.github.fernthedev.bungee;

import com.github.fernthedev.Universal.EnabledClasses;
import litebans.api.Events;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

public class ReportPlusAB extends Plugin {

    private static ReportPlusAB instance;

    public static String versionNumber;


    @Override
    public void onEnable() {
        instance = this;
        // getLogger().info(ChatColor.RED + "BUNGEE IS NOT SUPPORTED AT THIS TIME");
        if (getProxy().getPluginManager().getPlugin("LiteBans") != null)
            EnabledClasses.whichPunishment = EnabledClasses.WhichBan.LITEBANS;
        else if (getProxy().getPluginManager().getPlugin("AdvancedBan") != null)
            EnabledClasses.whichPunishment = EnabledClasses.WhichBan.ADVANCEDBAN;
        else EnabledClasses.whichPunishment = null;

        if (EnabledClasses.whichPunishment == null) {
            getLogger().warning("No compatible punishment system running, closing");
            getLogger().warning("Currently supported punishment systems are AdvancedBan and LiteBans.");
            this.onDisable();
            return;
        }

        if (EnabledClasses.whichPunishment == EnabledClasses.WhichBan.LITEBANS) {
            Events.get().register(new LitebansNotify());
        }

        if(EnabledClasses.whichPunishment ==  EnabledClasses.WhichBan.ADVANCEDBAN) {
            getProxy().getPluginManager().registerListener(this, new AdvancedBanNotify());
        }

        getLogger().info("Reportplus for " + EnabledClasses.getSystemName() + " has now been enabled.");


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
