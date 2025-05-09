package com.dreamfirestudios.dreamauth.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticEnumPulseConfig;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamauth.DreamAuth;
import com.dreamfirestudios.dreamauth.Enum.InventoryItems;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


@PulseAutoRegister
public class DreamfireAuthInventoryItems extends StaticEnumPulseConfig<DreamfireAuthInventoryItems, InventoryItems, ItemStack> {
    @Override
    public JavaPlugin mainClass() {return DreamAuth.GetDreamfireAuth();}
    @Override
    protected Class<InventoryItems> getKeyClass () {return InventoryItems.class;}
    @Override
    protected Class<ItemStack> getValueClass () {return ItemStack.class;}
    @Override
    protected ItemStack getDefaultValueFor (InventoryItems craftLegendsCoreInventoryItem) {return craftLegendsCoreInventoryItem.ReturnItemStack();}
}