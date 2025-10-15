package site.scalarstudios.elago.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.BuiltInRegistries;

import site.scalarstudios.elago.datacomponent.ElagoDataComponents;

import java.util.List;

/**
 * A custom potion item that can be used multiple times before being consumed.
 * Each use applies a specified effect to the user.
 * This can't be right and is probably very wrong. FML
 *
 * @author Lemon_Juiced
 */
public class ElagoPotionItem extends PotionItem {
    private static final int MAX_USES = 3;
    private final Holder<MobEffect> customEffect;
    private final int customDurationTicks;
    private final int customAmplifier;

    public ElagoPotionItem(Item.Properties properties, MobEffect effect, int durationSeconds, int amplifier) {
        super(properties);
        this.customEffect = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(effect);
        this.customDurationTicks = durationSeconds * 20;
        this.customAmplifier = amplifier;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        ItemStack result = super.finishUsingItem(stack, level, entityLiving);
        // Apply custom effect
        if (!level.isClientSide && customEffect != null) {
            entityLiving.addEffect(new MobEffectInstance(customEffect, customDurationTicks, customAmplifier));
        }
        int uses = result.get(ElagoDataComponents.ELAGO_POTION_USES.get()) != null ? result.get(ElagoDataComponents.ELAGO_POTION_USES.get()) : MAX_USES;
        uses--;
        if (uses > 0) {
            result.set(ElagoDataComponents.ELAGO_POTION_USES.get(), uses);
            return result;
        } else {
            return new ItemStack(ElagoItems.BOTTLE_GOURD.get());
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int uses = stack.get(ElagoDataComponents.ELAGO_POTION_USES.get()) != null ? stack.get(ElagoDataComponents.ELAGO_POTION_USES.get()) : MAX_USES;
        tooltipComponents.add(Component.translatable("tooltip.elago_potion.uses_remaining", uses, MAX_USES).withStyle(ChatFormatting.AQUA));
    }
}
