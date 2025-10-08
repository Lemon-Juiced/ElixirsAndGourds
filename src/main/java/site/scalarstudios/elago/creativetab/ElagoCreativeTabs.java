package site.scalarstudios.elago.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.elago.ElixirsAndGourds;
import site.scalarstudios.elago.item.ElagoItems;

public class ElagoCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElixirsAndGourds.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ELAGO_TAB = CREATIVE_MODE_TABS.register("elago_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.elago"))
            .icon(() -> new ItemStack(ElagoItems.GOURD.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ELAGO_TAB.get()) {
            event.accept(ElagoItems.GOURD.get());
            event.accept(ElagoItems.BOTTLE_GOURD.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
