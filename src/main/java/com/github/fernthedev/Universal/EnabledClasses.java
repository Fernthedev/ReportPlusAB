package com.github.fernthedev.Universal;

import litebans.api.Events;

public class EnabledClasses {

    public static void registerLitebans(Events.Listener litebansNotify) {
        Events.get().register(litebansNotify);
    }

    public enum WhichBan {
        ADVANCEDBAN,
        LITEBANS
    }

    public static String getSystemName() {
        if(whichPunishment == WhichBan.ADVANCEDBAN) return "AdvancedBan";
        else if (whichPunishment == WhichBan.LITEBANS) return "LiteBans";
        return null;
    }



    public static WhichBan whichPunishment;



}
