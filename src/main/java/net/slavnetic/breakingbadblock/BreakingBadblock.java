package net.slavnetic.breakingbadblock;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.slavnetic.breakingbadblock.block.ModBlocks;
import net.slavnetic.breakingbadblock.item.ModCreativeModeTabs;
import net.slavnetic.breakingbadblock.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BreakingBadblock.MOD_ID)
public class BreakingBadblock
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "breakingbadblock";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public BreakingBadblock()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.HEISENBURGHAT);
            event.accept(ModItems.HEISENBURGGLASSES);

        }

        if (event.getTab() == ModCreativeModeTabs.BREAKINGBADBLOCK_TAB)
            event.accept(ModBlocks.BBBLOCK);


        if(event.getTab() == ModCreativeModeTabs.BREAKINGBADBLOCK_TAB){
            event.accept(ModItems.HEISENBURGHAT);
            event.accept(ModItems.HEISENBURGGLASSES);
            event.accept(ModItems.BOXCUTTER);

        }

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
