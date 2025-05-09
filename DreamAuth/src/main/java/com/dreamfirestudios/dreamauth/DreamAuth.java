package com.dreamfirestudios.dreamauth;

import com.dreamfirestudios.dreamCommand.DreamCommand;
import com.dreamfirestudios.dreamCore.DreamfireJava.DreamfireClassAPI;
import com.dreamfirestudios.dreamauth.API.DreamfireAuthAPI;
import com.dreamfirestudios.dreamauth.DreamfireVariableTest.DreamfireAuthInventoryItemVariableTest;
import com.dreamfirestudios.dreamauth.DreamfireVariableTest.DreamfireAuthMessageVariableTest;
import com.dreamfirestudios.dreamauth.DreamfireVariableTest.DreamfireAuthPermissionVariableTest;
import org.bukkit.plugin.java.JavaPlugin;

public final class DreamAuth extends JavaPlugin {
    private static DreamAuth craftLegendsCore;
    public static DreamAuth GetDreamfireAuth(){return craftLegendsCore;}

    @Override
    public void onEnable() {
        craftLegendsCore = this;
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new DreamfireAuthMessageVariableTest());
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new DreamfireAuthInventoryItemVariableTest());
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new DreamfireAuthPermissionVariableTest());
        DreamfireAuthAPI.DreamfireDiscordReloadConfigs();
        DreamfireClassAPI.RegisterClasses(this);
        DreamCommand.RegisterRaw(this);
    }
}