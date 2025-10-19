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
import site.scalarstudios.elago.block.ElagoBlocks;
import site.scalarstudios.elago.item.ElagoItems;

public class ElagoCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElixirsAndGourds.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ELAGO_ITEMS_TAB = CREATIVE_MODE_TABS.register("elago_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.elago.items"))
            .icon(() -> new ItemStack(ElagoItems.GOURD.get()))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ELAGO_GOURDS_TAB = CREATIVE_MODE_TABS.register("elago_gourds", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.elago.gourds"))
            .icon(() -> new ItemStack(ElagoItems.LARGE_BOTTLE_GOURD.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ELAGO_ITEMS_TAB.get()) {
            event.accept(ElagoItems.GOURD.get());
            event.accept(ElagoItems.SMALL_BOTTLE_GOURD.get());
            event.accept(ElagoItems.MEDIUM_BOTTLE_GOURD.get());
            event.accept(ElagoItems.LARGE_BOTTLE_GOURD.get());

            event.accept(ElagoBlocks.WILD_GOURD.get());
            event.accept(ElagoBlocks.CARVED_WILD_GOURD.get());
            event.accept(ElagoBlocks.JACK_O_GOURD.get());
        } else if (event.getTab() == ELAGO_GOURDS_TAB.get()) {
            // event.accept(ElagoItems.SMALL_GOURD_OF_HEALING.get());
            event.accept(ElagoItems.SMALL_GOURD_OF_THE_TURTLE_MASTER_1.get());
            event.accept(ElagoItems.SMALL_GOURD_OF_THE_TURTLE_MASTER_PLUS.get());
            event.accept(ElagoItems.SMALL_GOURD_OF_THE_TURTLE_MASTER_2.get());
            event.accept(ElagoItems.MEDIUM_GOURD_OF_THE_TURTLE_MASTER_1.get());
            event.accept(ElagoItems.MEDIUM_GOURD_OF_THE_TURTLE_MASTER_PLUS.get());
            event.accept(ElagoItems.MEDIUM_GOURD_OF_THE_TURTLE_MASTER_2.get());
            event.accept(ElagoItems.LARGE_GOURD_OF_THE_TURTLE_MASTER_1.get());
            event.accept(ElagoItems.LARGE_GOURD_OF_THE_TURTLE_MASTER_PLUS.get());
            event.accept(ElagoItems.LARGE_GOURD_OF_THE_TURTLE_MASTER_2.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
