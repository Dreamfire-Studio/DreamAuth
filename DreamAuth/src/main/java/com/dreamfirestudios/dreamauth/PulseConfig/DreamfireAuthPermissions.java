package com.dreamfirestudios.dreamauth.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticEnumPulseConfig;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamauth.DreamAuth;
import com.dreamfirestudios.dreamauth.Enum.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class DreamfireAuthPermissions extends StaticEnumPulseConfig<DreamfireAuthPermissions, Permissions, String> {
    @Override
    public JavaPlugin mainClass() {return DreamAuth.GetDreamfireAuth();}
    @Override
    protected Class<Permissions> getKeyClass() {return Permissions.class;}
    @Override
    protected Class<String> getValueClass() {return String.class;}
    @Override
    protected String getDefaultValueFor(Permissions craftLegendsCorePermission) {return craftLegendsCorePermission.permission;}

    public boolean DoesPlayerHavePermission(Permissions permission, Player player, boolean sendError){
        if(permission == null || player == null) return false;
        var user = com.dreamfirestudios.dreamCore.DreamfireLuckPerms.DreamfireLuckPerms.getUser(player);
        var permissionState = com.dreamfirestudios.dreamCore.DreamfireLuckPerms.DreamfireLuckPerms.hasPermission(user, getDefaultValueFor(permission));
        if(!permissionState && sendError) com.dreamfirestudios.dreamCore.DreamfireChat.DreamfireChat.SendMessageToPlayer(player, permission.error);
        return permissionState;
    }
}