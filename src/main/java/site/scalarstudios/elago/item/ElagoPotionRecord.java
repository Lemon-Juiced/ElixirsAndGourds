package site.scalarstudios.elago.item;

import net.minecraft.world.effect.MobEffect;

public record ElagoPotionRecord(MobEffect effect, int amplifier, int duration, String name) { }
