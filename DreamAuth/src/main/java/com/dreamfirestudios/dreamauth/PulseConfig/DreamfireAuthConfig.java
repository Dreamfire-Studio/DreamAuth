package com.dreamfirestudios.dreamauth.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticPulseConfig;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamauth.DreamAuth;
import com.dreamfirestudios.dreamauth.Event.DreamfireAuthEnableSystemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;

@PulseAutoRegister
public class DreamfireAuthConfig extends StaticPulseConfig<DreamfireAuthConfig> {
    @Override
    public JavaPlugin mainClass() {return DreamAuth.GetDreamfireAuth();}
    @com.dreamfirestudios.dreamConfig.Interface.StorageComment("WARNING: SYSTEM WONT RUN IF FALSE!")
    public boolean systemEnabled = true;
    @com.dreamfirestudios.dreamConfig.Interface.StorageComment("Display debugs in the console logs for changes in this config!")
    public boolean debugConfig = false;

    public void ToggleSystemEnabled(Consumer<DreamfireAuthConfig> onSuccess, boolean newState){
        new DreamfireAuthEnableSystemEvent(systemEnabled, newState);
        systemEnabled = newState;
        SaveConfig(onSuccess, Throwable::printStackTrace);
    }
}
