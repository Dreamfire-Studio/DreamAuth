package com.dreamfirestudios.dreamauth.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticPulseConfig;
import com.dreamfirestudios.dreamConfig.SaveableObjects.SaveableHashmap;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.dreamauth.DreamAuth;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


@PulseAutoRegister
public class DreamfireAuthSerilizableItems extends StaticPulseConfig<DreamfireAuthSerilizableItems> {
    @Override
    public JavaPlugin mainClass() {return DreamAuth.GetDreamfireAuth();}

    public SaveableHashmap<String, ItemStack> itemStackSaveableHashmap = new SaveableHashmap<>(String.class, ItemStack.class);

    public void AddItemStack(String id, ItemStack itemStack){
        itemStackSaveableHashmap.getHashMap().put(id, itemStack);
    }

    public ItemStack GetItemStack(String id){
        return itemStackSaveableHashmap.getHashMap().getOrDefault(id, null);
    }
}
