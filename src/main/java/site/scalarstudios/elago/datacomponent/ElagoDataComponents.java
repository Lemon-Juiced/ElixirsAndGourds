package site.scalarstudios.elago.datacomponent;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.elago.ElixirsAndGourds;

import java.util.function.Supplier;

public class ElagoDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, ElixirsAndGourds.MODID);

    public static final Supplier<DataComponentType<Integer>> ELAGO_POTION_USES = DATA_COMPONENT_TYPES.register("elago_potion_uses", () -> DataComponentType.<Integer>builder().persistent(Codec.INT).build());

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}

