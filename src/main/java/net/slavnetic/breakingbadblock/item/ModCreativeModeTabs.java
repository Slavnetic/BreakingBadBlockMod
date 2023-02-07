package net.slavnetic.breakingbadblock.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slavnetic.breakingbadblock.BreakingBadblock;


@Mod.EventBusSubscriber(modid = BreakingBadblock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab BREAKINGBADBLOCK_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        BREAKINGBADBLOCK_TAB = event.registerCreativeModeTab(new ResourceLocation(BreakingBadblock.MOD_ID, "breakingbadblock_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.HEISENBURGHAT.get()))
                        .title(Component.translatable("creativemodetab.breakingbadblock_tab")));
    }
}
