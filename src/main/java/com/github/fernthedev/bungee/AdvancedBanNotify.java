package com.github.fernthedev.bungee;

import me.leoko.advancedban.bungee.event.PunishmentEvent;
import me.xbones.reportplus.api.ReportPlusAPI;
import me.xbones.reportplus.api.punishments.Punishment;
import me.xbones.reportplus.api.punishments.PunishmentType;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class AdvancedBanNotify implements Listener {


    @EventHandler
    public void onReport(PunishmentEvent e) {
        ReportPlusAB.getInstance().getLogger().info("Punishment going to discord initiated!");
        me.leoko.advancedban.utils.Punishment punish = e.getPunishment();
        String punisher = punish.getOperator();
        String punished = punish.getName();
        String reason = punish.getReason();

        PunishmentType type;
        switch (punish.getType()) {
            case BAN:
            case TEMP_IP_BAN:
            case TEMP_BAN:
            case IP_BAN:
                type = PunishmentType.BAN;
                break;
            case KICK:
                type = PunishmentType.KICK;
                break;
            case MUTE:
                type = PunishmentType.MUTE;
                break;
            case TEMP_MUTE:
                type = PunishmentType.TEMPMUTE;
                break;
            case WARNING:
            case TEMP_WARNING:
            default:
                type = PunishmentType.WARN;
                break;
        }


        /*
        Server server = ProxyServer.getInstance().getPlayer(punished).getServer();
        ServerInfo serverInfo;


        if(server != null) serverInfo = server.getInfo();
        else serverInfo = null;

        if(serverInfo == null) {
            ProxiedPlayer randomP =ProxyServer.getInstance().getPlayers().iterator().next();
            serverInfo = randomP.getServer().getInfo();
        }*/


        Punishment punishment = new Punishment(punisher, punished, reason, type);

        ReportPlusAPI.getApi().sendPunishment(punishment);
        ReportPlusAB.getInstance().getLogger().info("Punisher was " + punisher + " and punished " + punished + " for the reason " + reason + " and punishment was " + type.name());
    }
}
