package site.scalarstudios.elago;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = ElixirsAndGourds.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = ElixirsAndGourds.MODID, value = Dist.CLIENT)
public class ElixirsAndGourdsClient {
    public ElixirsAndGourdsClient(ModContainer container) {}

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {}
}
