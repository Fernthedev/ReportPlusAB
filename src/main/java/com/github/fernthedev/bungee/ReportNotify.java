package com.github.fernthedev.bungee;

import me.leoko.advancedban.bungee.event.PunishmentEvent;
import me.xbones.reportplus.bungee.ReportPlus;
import me.xbones.reportplus.bungee.punishments.Punishment;
import me.xbones.reportplus.bungee.punishments.PunishmentType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class ReportNotify implements Listener {


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
                type = PunishmentType.BAN;
                break;
            case IP_BAN:
                type = PunishmentType.BAN;
                break;
            case TEMP_BAN:
                type = PunishmentType.BAN;
                break;
            case TEMP_IP_BAN:
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
                type = PunishmentType.WARN;
                break;
            case TEMP_WARNING:
                type = PunishmentType.WARN;
                break;
            default:
                type = PunishmentType.WARN;
                break;
        }

        ServerInfo serverInfo = ProxyServer.getInstance().getPlayer(punisher).getServer().getInfo();

        if(serverInfo == null) {
            ProxiedPlayer randomP =ProxyServer.getInstance().getPlayers().iterator().next();
            serverInfo = randomP.getServer().getInfo();
        }


        Punishment punishment = new Punishment(punisher, punished, reason, type,serverInfo);

        ReportPlus.getAPI().sendMessageToAllServers(punishment);
        ReportPlusAB.getInstance().getLogger().info("Punisher was " + punisher + " and punished " + punished + " for the reason " + reason + " and punishment was " + punished);
    }
}
