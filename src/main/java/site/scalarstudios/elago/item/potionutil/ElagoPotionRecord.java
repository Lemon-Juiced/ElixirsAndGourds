package site.scalarstudios.elago.item.potionutil;

import net.minecraft.world.effect.MobEffect;

public record ElagoPotionRecord(MobEffect effect, int amplifier, double duration, String name) { }