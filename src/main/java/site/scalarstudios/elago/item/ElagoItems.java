package site.scalarstudios.elago.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.elago.ElixirsAndGourds;
import site.scalarstudios.elago.block.ElagoBlocks;
import site.scalarstudios.elago.item.potionutil.ElagoPotionRecord;
import site.scalarstudios.elago.item.potionutil.ElagoPotionRecords;

import java.util.function.Supplier;

import static site.scalarstudios.elago.item.potionutil.ElagoPotionRecords.*;

public class ElagoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(ElixirsAndGourds.MODID);

    // Gourds
    public static final Supplier<Item> GOURD = ITEMS.register("gourd", () ->new ItemNameBlockItem(ElagoBlocks.GOURDS.get(), new Item.Properties().food(ElagoFoods.GOURD)));
    public static final Supplier<Item> SMALL_BOTTLE_GOURD = ITEMS.register("small_bottle_gourd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> MEDIUM_BOTTLE_GOURD = ITEMS.register("medium_bottle_gourd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LARGE_BOTTLE_GOURD = ITEMS.register("large_bottle_gourd", () -> new Item(new Item.Properties()));

    // Elago Potions
    public static final Supplier<Item> SMALL_GOURD_OF_THE_TURTLE_MASTER_1 = ITEMS.register("small_gourd_of_the_turtle_master_1", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 4, ElagoPotionRecords.TURTLE_MASTER_1A, ElagoPotionRecords.TURTLE_MASTER_1B));
    public static final Supplier<Item> SMALL_GOURD_OF_THE_TURTLE_MASTER_PLUS = ITEMS.register("small_gourd_of_the_turtle_master_plus", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 4, ElagoPotionRecords.TURTLE_MASTER_PLUSA, ElagoPotionRecords.TURTLE_MASTER_PLUSB));
    public static final Supplier<Item> SMALL_GOURD_OF_THE_TURTLE_MASTER_2 = ITEMS.register("small_gourd_of_the_turtle_master_2", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 4, ElagoPotionRecords.TURTLE_MASTER_2A, ElagoPotionRecords.TURTLE_MASTER_2B));
    public static final Supplier<Item> MEDIUM_GOURD_OF_THE_TURTLE_MASTER_1 = ITEMS.register("medium_gourd_of_the_turtle_master_1", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 8, ElagoPotionRecords.TURTLE_MASTER_1A, ElagoPotionRecords.TURTLE_MASTER_1B));
    public static final Supplier<Item> MEDIUM_GOURD_OF_THE_TURTLE_MASTER_PLUS = ITEMS.register("medium_gourd_of_the_turtle_master_plus", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 8, ElagoPotionRecords.TURTLE_MASTER_PLUSA, ElagoPotionRecords.TURTLE_MASTER_PLUSB));
    public static final Supplier<Item> MEDIUM_GOURD_OF_THE_TURTLE_MASTER_2 = ITEMS.register("medium_gourd_of_the_turtle_master_2", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 8, ElagoPotionRecords.TURTLE_MASTER_2A, ElagoPotionRecords.TURTLE_MASTER_2B));
    public static final Supplier<Item> LARGE_GOURD_OF_THE_TURTLE_MASTER_1 = ITEMS.register("large_gourd_of_the_turtle_master_1", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 16, ElagoPotionRecords.TURTLE_MASTER_1A, ElagoPotionRecords.TURTLE_MASTER_1B));
    public static final Supplier<Item> LARGE_GOURD_OF_THE_TURTLE_MASTER_PLUS = ITEMS.register("large_gourd_of_the_turtle_master_plus", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 16, ElagoPotionRecords.TURTLE_MASTER_PLUSA, ElagoPotionRecords.TURTLE_MASTER_PLUSB));
    public static final Supplier<Item> LARGE_GOURD_OF_THE_TURTLE_MASTER_2 = ITEMS.register("large_gourd_of_the_turtle_master_2", () -> new ElagoDualPotionItem(new Item.Properties().stacksTo(1), 16, ElagoPotionRecords.TURTLE_MASTER_2A, ElagoPotionRecords.TURTLE_MASTER_2B));

    public static void addGourds() {
        String[] sizes = new String[]{"small", "medium", "large"};
        int[] uses = new int[]{4, 8, 16};
        ElagoPotionRecord[] records = new ElagoPotionRecord[]{REGENERATION_1, REGENERATION_PLUS, REGENERATION_2, SWIFTNESS_1, SWIFTNESS_PLUS, SWIFTNESS_2, FIRE_RESISTANCE, FIRE_RESISTANCE_PLUS, HEALING_1, HEALING_2, NIGHT_VISION, NIGHT_VISION_PLUS, STRENGTH_1, STRENGTH_PLUS, STRENGTH_2, LEAPING_1, LEAPING_PLUS, LEAPING_2, WATER_BREATHING, WATER_BREATHING_PLUS, INVISIBILITY, INVISIBILITY_PLUS, SLOW_FALLING, SLOW_FALLING_PLUS, LUCK, POISON_1, POISON_PLUS, POISON_2, WEAKNESS, WEAKNESS_PLUS, SLOWNESS_1, SLOWNESS_PLUS, SLOWNESS_4, HARMING_1, HARMING_2, INFESTATION, OOZING, WEAVING, WIND_CHARGING};

        // Iterate records first, then sizes so each record gets small/medium/large registered before moving to next record
        for (int r = 0; r < records.length; r++) {
            for (int s = 0; s < sizes.length; s++) {
                // Make loop variables effectively final for the lambda
                int finalR = r;
                int finalS = s;
                ITEMS.register(sizes[finalS] + "_gourd_of_" + records[finalR].name(), () -> new ElagoPotionItem(new Item.Properties().stacksTo(1), uses[finalS], records[finalR]));
            }
        }
    }

    public static void register(IEventBus eventBus) {
        addGourds();
        ITEMS.register(eventBus);
    }
}
