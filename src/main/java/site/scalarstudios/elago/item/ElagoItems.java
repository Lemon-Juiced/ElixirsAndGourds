package site.scalarstudios.elago.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.elago.ElixirsAndGourds;
import site.scalarstudios.elago.block.ElagoBlocks;

import java.util.function.Supplier;

public class ElagoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(ElixirsAndGourds.MODID);

    // Gourds
    public static final Supplier<Item> GOURD = ITEMS.register("gourd", () ->new ItemNameBlockItem(ElagoBlocks.GOURDS.get(), new Item.Properties().food(ElagoFoods.GOURD)));
    public static final Supplier<Item> BOTTLE_GOURD_SMALL = ITEMS.register("bottle_gourd_small", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BOTTLE_GOURD_MEDIUM = ITEMS.register("bottle_gourd_medium", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BOTTLE_GOURD_LARGE = ITEMS.register("bottle_gourd_large", () -> new Item(new Item.Properties()));

    // Elago Potions
    public static final Supplier<Item> GOURD_OF_HEALING = ITEMS.register("gourd_of_healing", () -> new ElagoPotionItem(new Item.Properties().stacksTo(1), 4, MobEffects.HEAL.value(),1, 1));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
