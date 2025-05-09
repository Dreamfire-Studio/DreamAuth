package com.dreamfirestudios.dreamauth.Enum;

import com.dreamfirestudios.dreamauth.DreamAuth;

public enum Messages {
    ConsoleEnabledSystem(String.format("#7fff36%s has been enabled!", DreamAuth.GetDreamfireAuth().getName())),
    ConsoleDisableSystem(String.format("#7fff36%s has been disabled!", DreamAuth.GetDreamfireAuth().getName())),
    PlayerReloadedConfig(String.format("#7fff36%s configs have been reloaded!", DreamAuth.GetDreamfireAuth().getName())),
    PlayerSerlizedItem("#7fff36You have added a item to the serialized items: #ffffff%s"),
    PlayerResetConfig(String.format("#7fff36%s configs have been reset!", DreamAuth.GetDreamfireAuth().getName())),
    SystemIsntEnabled(String.format("#7fff36%s Isn't Enabled!", DreamAuth.GetDreamfireAuth().getName()));

    public final String message;
    Messages(String message){
        this.message = message;
    }
}
