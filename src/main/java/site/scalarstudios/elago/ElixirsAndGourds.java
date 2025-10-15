package site.scalarstudios.elago;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import site.scalarstudios.elago.block.ElagoBlocks;
import site.scalarstudios.elago.creativetab.ElagoCreativeTabs;
import site.scalarstudios.elago.datacomponent.ElagoDataComponents;
import site.scalarstudios.elago.item.ElagoItems;

@Mod(ElixirsAndGourds.MODID)
public class ElixirsAndGourds {
    public static final String MODID = "elago";

    public ElixirsAndGourds(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Items
        ElagoItems.register(modEventBus);
        ElagoBlocks.register(modEventBus);

        // Register Data Components
        ElagoDataComponents.register(modEventBus);

        // Register Creative Tabs
        ElagoCreativeTabs.register(modEventBus);
        modEventBus.addListener(ElagoCreativeTabs::registerTabs);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
