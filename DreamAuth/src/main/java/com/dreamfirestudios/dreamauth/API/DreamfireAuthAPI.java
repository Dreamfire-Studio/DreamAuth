package com.dreamfirestudios.dreamauth.API;

import com.dreamfirestudios.dreamConfig.DreamConfig;
import com.dreamfirestudios.dreamauth.DreamAuth;
import com.dreamfirestudios.dreamauth.Event.DreamfireAuthReloadConfigEvent;
import com.dreamfirestudios.dreamauth.Event.DreamfireAuthResetConfigEvent;
import com.dreamfirestudios.dreamauth.PulseConfig.*;
import org.bukkit.inventory.ItemStack;

public class DreamfireAuthAPI {
    public static void DreamfireDiscordEnableSystem(boolean state){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, craftLegendsCoreConfig -> {
            craftLegendsCoreConfig.systemEnabled = state;
            craftLegendsCoreConfig.SaveConfig(iPulseConfig -> {}, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void DreamfireDiscordEnableSystem(){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, craftLegendsCoreConfig -> {
            craftLegendsCoreConfig.systemEnabled = !craftLegendsCoreConfig.systemEnabled;
            craftLegendsCoreConfig.SaveConfig(iPulseConfig -> {}, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void SerializeItem(String id, ItemStack itemStack){
        DreamfireAuthSerilizableItems.ReturnStaticAsync(DreamfireAuthSerilizableItems.class, craftLegendsCoreSerilizableItems -> {
            craftLegendsCoreSerilizableItems.AddItemStack(id, itemStack);
            craftLegendsCoreSerilizableItems.SaveConfig(iPulseConfig -> {}, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void DreamfireDiscordResetConfigs(){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            DreamConfig.GetDreamfireConfig().RegisterStatic(DreamAuth.GetDreamfireAuth(), true);
            new DreamfireAuthResetConfigEvent();
        }, Throwable::printStackTrace);
    }

    public static void DreamfireDiscordReloadConfigs(){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            DreamConfig.GetDreamfireConfig().RegisterStatic(DreamAuth.GetDreamfireAuth(), true);
            new DreamfireAuthReloadConfigEvent();
        }, Throwable::printStackTrace);
    }
}