package com.dreamfirestudios.dreamauth.DynamicPulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.DynamicPulseMongo;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class PlayerConfig extends DynamicPulseMongo<PlayerConfig> {
    public PlayerConfig(){
        super(UUID.randomUUID().toString());
    }
    public PlayerConfig(String pulseConfigID) {
        super(pulseConfigID);
    }
    @Override
    public String databaseName() {
        return "";
    }
}
