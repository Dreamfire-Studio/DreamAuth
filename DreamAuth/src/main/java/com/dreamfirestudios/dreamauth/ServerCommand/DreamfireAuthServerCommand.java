package com.dreamfirestudios.dreamauth.ServerCommand;

import com.dreamfirestudios.dreamCommand.Interface.PCMethod;
import com.dreamfirestudios.dreamCommand.Interface.PCSignature;
import com.dreamfirestudios.dreamCommand.ServerCommand;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamauth.PulseConfig.DreamfireAuthMessages;
import com.dreamfirestudios.dreamauth.API.DreamfireAuthAPI;
import com.dreamfirestudios.dreamauth.Enum.Messages;
import com.dreamfirestudios.dreamauth.PulseConfig.DreamfireAuthConfig;
import org.bukkit.command.CommandSender;

import java.util.LinkedHashMap;

@PulseAutoRegister
public class DreamfireAuthServerCommand extends ServerCommand {

    public DreamfireAuthServerCommand() {
        super("DA_server", false);
    }

    @Override
    public void NoMethodFound(CommandSender commandSender, String s, String[] strings) {}
    @Override
    public String helpMenuPrefix(CommandSender commandSender) {return "";}
    @Override
    public LinkedHashMap<String, String> helpMenuFormat(CommandSender commandSender, LinkedHashMap<String, String> linkedHashMap) {return new LinkedHashMap<>();}
    @Override
    public String helpMenuSuffix(CommandSender commandSender) {return "";}

    @PCMethod
    @PCSignature({})
    public void TimeStealCoreMethod(CommandSender commandSender){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            DreamfireAuthMessages.ReturnStaticAsync(DreamfireAuthMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.SystemIsntEnabled);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"enable"})
    public void TimeStealCoreEnableMethod(CommandSender commandSender, boolean state){
        DreamfireAuthAPI.DreamfireDiscordEnableSystem(state);
        DreamfireAuthMessages.ReturnStaticAsync(DreamfireAuthMessages.class, craftLegendsCoreMessages -> {
            craftLegendsCoreMessages.SendMessageToConsole(state ? Messages.ConsoleEnabledSystem : Messages.ConsoleDisableSystem);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"configs", "reset"})
    public void TimeStealCoreConfigsResetMethod(CommandSender commandSender){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            DreamfireAuthAPI.DreamfireDiscordResetConfigs();
            DreamfireAuthMessages.ReturnStaticAsync(DreamfireAuthMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.PlayerResetConfig);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"configs", "reload"})
    public void TimeStealCoreConfigsReloadMethod(CommandSender commandSender){
        DreamfireAuthConfig.ReturnStaticAsync(DreamfireAuthConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            DreamfireAuthAPI.DreamfireDiscordResetConfigs();
            DreamfireAuthMessages.ReturnStaticAsync(DreamfireAuthMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.PlayerReloadedConfig);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }
}

