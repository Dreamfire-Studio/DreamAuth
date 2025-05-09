package com.dreamfirestudios.dreamauth.Event;

import com.dreamfirestudios.dreamauth.DreamAuth;
import com.dreamfirestudios.dreamauth.PulseConfig.DreamfireAuthConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class DreamfireAuthReloadConfigEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public DreamfireAuthReloadConfigEvent(){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, dreamfireDiscordConfig -> {
            if(dreamfireDiscordConfig.systemEnabled) return;
            Bukkit.getScheduler().runTask(DreamAuth.GetDreamfireAuth(), () -> {Bukkit.getPluginManager().callEvent(this);});
        }, Throwable::printStackTrace);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
}
