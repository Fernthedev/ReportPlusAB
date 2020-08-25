package com.github.fernthedev.Universal;

import litebans.api.Events;

public class LitebansClassLoader {
    public static void registerLitebans(Events.Listener litebansNotify) {
        Events.get().register(litebansNotify);
    }
}
