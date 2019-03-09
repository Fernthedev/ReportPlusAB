package com.github.fernthedev.spigot;

import litebans.api.Entry;
import litebans.api.Events;
import me.xbones.reportplus.spigot.ReportPlus;
import me.xbones.reportplus.spigot.punishments.Punishment;
import me.xbones.reportplus.spigot.punishments.PunishmentType;

public class LitebansNotify extends Events.Listener {

    @Override
    public void entryAdded(Entry entry) {

        String punisher = entry.getExecutorName();
        String punished = entry.getRemovedByName();
        String reason = entry.getReason();

        ReportPlusAB.getInstance().getLogger().info(entry.toString());


        if(entry.getRemovedByName() == null) {
            ReportPlusAB.getInstance().getLogger().info("The banned player does not exist, does it?");
            return;
        }

        PunishmentType type;

        switch (entry.getType()) {
            case "ban":
                type = PunishmentType.BAN;
                break;
            case "kick":
                type = PunishmentType.KICK;
                break;
            case "mute":
                type = PunishmentType.MUTE;
                break;
            case "warn":
                type = PunishmentType.WARN;
                break;
            default:
                type = PunishmentType.BAN;
                break;
        }

        ReportPlusAB.getInstance().getLogger().info("Punisher was " + punisher + " and punished " + punished + " for the reason " + reason + " and punishment was " + type.name());
        Punishment punishment = new Punishment(punisher, punished, reason, type);

        ReportPlus.getApi().sendPunishment(punishment);


    }

}
