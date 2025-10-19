package site.scalarstudios.elago.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.elago.ElixirsAndGourds;
import site.scalarstudios.elago.item.ElagoItems;

import java.util.function.Supplier;

public class ElagoBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ElixirsAndGourds.MODID);

    // Blocks
    public static final DeferredBlock<Block> WILD_GOURD = registerBlock("wild_gourd", () -> new PumpkinBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .instrument(NoteBlockInstrument.DIDGERIDOO)
            .strength(1.0F).sound(SoundType.WOOD)
            .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CARVED_WILD_GOURD = registerBlock("carved_wild_gourd", () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .strength(1.0F)
            .sound(SoundType.WOOD)
            .isValidSpawn(Blocks::always)
            .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> JACK_O_GOURD = registerBlock("jack_o_gourd", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN)
            .strength(1.0F)
            .sound(SoundType.WOOD)
            .lightLevel((state) -> 15)
            .isValidSpawn(Blocks::always)
            .pushReaction(PushReaction.DESTROY)));

    // Crops
    public static final DeferredBlock<GourdBlock> GOURDS = registerBlock("gourds", () -> new GourdBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ElagoItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        // Register the blocks
        BLOCKS.register(eventBus);
    }
}
