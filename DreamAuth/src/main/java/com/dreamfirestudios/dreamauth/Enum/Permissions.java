package com.dreamfirestudios.dreamauth.Enum;

import com.dreamfirestudios.dreamauth.DreamAuth;

public enum Permissions {
    ReloadConfigs("TimeStealCore.Admin.ReloadConfigs", String.format("#7fff36%s: You do not have the permission to use this command!", DreamAuth.class.getSimpleName())),
    ResetConfigs("TimeStealCore.Admin.ResetConfigs", String.format("#7fff36%s: You do not have the permission to use this command!", DreamAuth.class.getSimpleName())),
    EnableSystem("TimeStealCore.Admin.EnableSystem", String.format("#7fff36%s: You do not have the permission to use this command!", DreamAuth.class.getSimpleName())),
    SerializeItem("TimeStealCore.Admin.SerilizeItem", String.format("#7fff36%s: You do not have the permission to use this command!", DreamAuth.class.getSimpleName())),
    AdminConsole("CraftLegendsPaper.Admin.SerilizeItem", String.format("#7fff36%s: You do not have the permission to use this command!", DreamAuth.class.getSimpleName())),
    RedrawRegions("TimeStealCore.Admin.RedrawRegions", String.format("#7fff36%s: You do not have the permission to use this command!", DreamAuth.class.getSimpleName()));

    public final String permission;
    public final String error;
    Permissions(String permission, String error){
        this.permission = permission;
        this.error = error;
    }
}
