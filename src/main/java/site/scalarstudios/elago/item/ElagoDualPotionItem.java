package site.scalarstudios.elago.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.registries.BuiltInRegistries;
import site.scalarstudios.elago.item.potionutil.ElagoPotionRecord;

public class ElagoDualPotionItem extends ElagoPotionItem {
    private final Holder<MobEffect> secondEffect;
    private final int secondDurationTicks;
    private final int secondAmplifier;

    public ElagoDualPotionItem(Item.Properties properties, int maxUses,  MobEffect effect1, double durationSeconds1, int amplifier1, MobEffect effect2, double durationSeconds2, int amplifier2) {
        super(properties, maxUses, effect1, durationSeconds1, amplifier1);
        this.secondEffect = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(effect2);
        this.secondDurationTicks = (int)Math.round(durationSeconds2 * 20.0);
        this.secondAmplifier = amplifier2;
    }

    public ElagoDualPotionItem(Item.Properties properties, int maxUses, MobEffect effect1, int durationSeconds1, int amplifier1, MobEffect effect2, int durationSeconds2, int amplifier2) {
        this(properties, maxUses, effect1, (double)durationSeconds1, amplifier1, effect2, (double)durationSeconds2, amplifier2);
    }

    public ElagoDualPotionItem(Item.Properties properties, int maxUses, ElagoPotionRecord record1, ElagoPotionRecord record2) {
        super(properties, maxUses, record1);
        this.secondEffect = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(record2.effect());
        this.secondDurationTicks = (int)Math.round((double)record2.duration() * 20.0);
        this.secondAmplifier = record2.amplifier();
    }


    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        ItemStack result = super.finishUsingItem(stack, level, entityLiving);
        if (!level.isClientSide && secondEffect != null) {
            entityLiving.addEffect(new MobEffectInstance(secondEffect, secondDurationTicks, secondAmplifier));
        }
        return result;
    }
}
