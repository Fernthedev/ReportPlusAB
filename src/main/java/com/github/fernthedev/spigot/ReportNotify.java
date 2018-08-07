package com.github.fernthedev.spigot;

import me.leoko.advancedban.bukkit.event.PunishmentEvent;
import me.xbones.reportplus.spigot.api.ReportPlusAPI;
import me.xbones.reportplus.spigot.punishments.Punishment;
import me.xbones.reportplus.spigot.punishments.PunishmentType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ReportNotify implements Listener {

    @EventHandler
    public void onReport(PunishmentEvent e) {
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
            default:
                type = PunishmentType.BAN;
                break;
        }

        Punishment punishment = new Punishment(punisher, punished, reason, type);


        boolean success = ReportPlusAPI.sendPunishment(punishment);
        ReportPlusAB.getInstance().getLogger().info("Punisher was " + punisher + " and punished " + punished + " for the reason " + reason + " and punishment was " + type.name());
        if (success) {
            ReportPlusAB.getInstance().getLogger().info("Report successful");
        }else {
            ReportPlusAB.getInstance().getLogger().info("Report failed");
        }

        /*

        ReportPlusAPI.sendMessageToChannel("422215872330072067", new EmbedBuilder()
                .setTitle("New Punishment")
                .setDescription("You have received a new punishment!")
                .setColor(java.awt.Color.RED)
                .addField("Punisher", punishment.getPunisher(), false)
                .addField("Punished", punishment.getPunished(), false)
                .addField("Reporter", punishment.getPunisher(), false)
                .addField("Type", punishment.getType().toString(), false));
*/
    }

}
