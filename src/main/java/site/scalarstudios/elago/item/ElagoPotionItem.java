package site.scalarstudios.elago.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.advancements.CriteriaTriggers;
import site.scalarstudios.elago.datacomponent.ElagoDataComponents;
import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.BuiltInRegistries;
import site.scalarstudios.elago.item.potionutil.ElagoPotionRecord;

public class ElagoPotionItem extends Item {
    private final int maxUses;
    private final Holder<MobEffect> customEffect;
    private final int customDurationTicks;
    private final int customAmplifier;

    public ElagoPotionItem(Item.Properties properties, int maxUses, MobEffect effect, double durationSeconds, int amplifier) {
        super(properties);
        this.maxUses = maxUses;
        this.customEffect = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(effect);
        this.customDurationTicks = (int)Math.round(durationSeconds * 20.0);
        this.customAmplifier = amplifier;
    }

    public ElagoPotionItem(Item.Properties properties, int maxUses, ElagoPotionRecord record) {
        this(properties, maxUses, record.effect(), (double)record.duration(), record.amplifier());
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        if (entityLiving instanceof Player player) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        if (!level.isClientSide && customEffect != null) {
            entityLiving.addEffect(new MobEffectInstance(customEffect, customDurationTicks, customAmplifier));
        }
        int uses = stack.get(ElagoDataComponents.ELAGO_POTION_USES.get()) != null ? stack.get(ElagoDataComponents.ELAGO_POTION_USES.get()) : this.maxUses;
        uses--;
        if (uses > 0) {
            stack.set(ElagoDataComponents.ELAGO_POTION_USES.get(), uses);
            return stack;
        } else {
            return new ItemStack(ElagoItems.SMALL_BOTTLE_GOURD.get());
        }
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int uses = stack.get(ElagoDataComponents.ELAGO_POTION_USES.get()) != null ? stack.get(ElagoDataComponents.ELAGO_POTION_USES.get()) : this.maxUses;
        tooltipComponents.add(Component.translatable("tooltip.elago_potion.uses_remaining", uses, this.maxUses).withStyle(ChatFormatting.AQUA));
    }
}