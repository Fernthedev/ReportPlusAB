package com.github.fernthedev.Universal;

public class EnabledClasses {

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
