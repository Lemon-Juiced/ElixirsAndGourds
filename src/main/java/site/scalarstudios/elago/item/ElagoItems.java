package site.scalarstudios.elago.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.elago.ElixirsAndGourds;
import site.scalarstudios.elago.block.ElagoBlocks;
import site.scalarstudios.elago.item.potionutil.ElagoPotionRecords;

import java.util.function.Supplier;

public class ElagoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(ElixirsAndGourds.MODID);

    // Gourds
    public static final Supplier<Item> GOURD = ITEMS.register("gourd", () ->new ItemNameBlockItem(ElagoBlocks.GOURDS.get(), new Item.Properties().food(ElagoFoods.GOURD)));
    public static final Supplier<Item> SMALL_BOTTLE_GOURD = ITEMS.register("small_bottle_gourd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> MEDIUM_BOTTLE_GOURD = ITEMS.register("medium_bottle_gourd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LARGE_BOTTLE_GOURD = ITEMS.register("large_bottle_gourd", () -> new Item(new Item.Properties()));

    // Elago Potions
    public static final Supplier<Item> SMALL_GOURD_OF_HEALING = ITEMS.register("small_gourd_of_healing", () -> new ElagoPotionItem(new Item.Properties().stacksTo(1), 4, MobEffects.HEAL.value(),1, 1));

    public static final Supplier<Item> SMALL_GOURD_OF_THE_TURTLE_MASTER_1 = ITEMS.register("small_gourd_of_the_turtle_master_1", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 4, ElagoPotionRecords.TURTLE_MASTER_1A, ElagoPotionRecords.TURTLE_MASTER_1B));
    public static final Supplier<Item> SMALL_GOURD_OF_THE_TURTLE_MASTER_PLUS = ITEMS.register("small_gourd_of_the_turtle_master_plus", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 4, ElagoPotionRecords.TURTLE_MASTER_PLUSA, ElagoPotionRecords.TURTLE_MASTER_PLUSB));
    public static final Supplier<Item> SMALL_GOURD_OF_THE_TURTLE_MASTER_2 = ITEMS.register("small_gourd_of_the_turtle_master_2", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 4, ElagoPotionRecords.TURTLE_MASTER_2A, ElagoPotionRecords.TURTLE_MASTER_2B));
    public static final Supplier<Item> MEDIUM_GOURD_OF_THE_TURTLE_MASTER_1 = ITEMS.register("medium_gourd_of_the_turtle_master_1", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 8, ElagoPotionRecords.TURTLE_MASTER_1A, ElagoPotionRecords.TURTLE_MASTER_1B));
    public static final Supplier<Item> MEDIUM_GOURD_OF_THE_TURTLE_MASTER_PLUS = ITEMS.register("medium_gourd_of_the_turtle_master_plus", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 8, ElagoPotionRecords.TURTLE_MASTER_PLUSA, ElagoPotionRecords.TURTLE_MASTER_PLUSB));
    public static final Supplier<Item> MEDIUM_GOURD_OF_THE_TURTLE_MASTER_2 = ITEMS.register("medium_gourd_of_the_turtle_master_2", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 8, ElagoPotionRecords.TURTLE_MASTER_2A, ElagoPotionRecords.TURTLE_MASTER_2B));
    public static final Supplier<Item> LARGE_GOURD_OF_THE_TURTLE_MASTER_1 = ITEMS.register("large_gourd_of_the_turtle_master_1", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 16, ElagoPotionRecords.TURTLE_MASTER_1A, ElagoPotionRecords.TURTLE_MASTER_1B));
    public static final Supplier<Item> LARGE_GOURD_OF_THE_TURTLE_MASTER_PLUS = ITEMS.register("large_gourd_of_the_turtle_master_plus", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 16, ElagoPotionRecords.TURTLE_MASTER_PLUSA, ElagoPotionRecords.TURTLE_MASTER_PLUSB));
    public static final Supplier<Item> LARGE_GOURD_OF_THE_TURTLE_MASTER_2 = ITEMS.register("large_gourd_of_the_turtle_master_2", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 16, ElagoPotionRecords.TURTLE_MASTER_2A, ElagoPotionRecords.TURTLE_MASTER_2B));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
