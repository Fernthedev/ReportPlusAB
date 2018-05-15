package com.github.fernthedev.bungee;

import me.leoko.advancedban.bungee.event.PunishmentEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ReportNotify implements Listener {


/*    @EventHandler
    public void onReport(PunishmentEvent e) {
        me.leoko.advancedban.utils.Punishment punish = e.getPunishment();
        String punisher = punish.getOperator();
        String punished = punish.getName();
        String reason = punish.getReason();
        PunishmentType type = PunishmentType.BAN;
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
        }

        Punishment punishment = new Punishment(punisher, punished, reason, type);
        ReportPlusAPI.sendPunishment(punishment);
        ReportPlusAB.getInstance().getLogger().info("Punisher was " + punisher + " and punished " + punished + " for the reason " + reason + " and punishment was " + type.name());
    }*/
}
