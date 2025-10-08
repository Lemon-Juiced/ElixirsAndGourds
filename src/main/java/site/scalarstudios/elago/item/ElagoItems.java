package site.scalarstudios.elago.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.elago.ElixirsAndGourds;

import java.util.function.Supplier;

public class ElagoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(ElixirsAndGourds.MODID);

    // Gourds
    public static final Supplier<Item> GOURD = ITEMS.register("gourd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BOTTLE_GOURD = ITEMS.register("bottle_gourd", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
