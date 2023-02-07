package net.slavnetic.breakingbadblock.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slavnetic.breakingbadblock.BreakingBadblock;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BreakingBadblock.MOD_ID);

    public static final RegistryObject<Item> HEISENBURGHAT = ITEMS.register("heisenburg_hat",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HEISENBURGGLASSES = ITEMS.register("heisenburg_glasses",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOXCUTTER = ITEMS.register("gusboxcutter",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
