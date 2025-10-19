package site.scalarstudios.elago.item.potionutil;

import net.minecraft.world.effect.MobEffects;

/**
 * A utility class to hold records of different Elago potions.
 * The ElagoPotionItem handles the conversion to ticks and other functionalities, this is just a data holder.
 */
public class ElagoPotionRecords {
    public static final ElagoPotionRecord REGENERATION_1 = new ElagoPotionRecord(MobEffects.REGENERATION.value(), 1, 45, "regeneration_1");
    public static final ElagoPotionRecord REGENERATION_PLUS = new ElagoPotionRecord(MobEffects.REGENERATION.value(), 1, convertMinutesToSeconds(1, 30), "regeneration_plus");
    public static final ElagoPotionRecord REGENERATION_2 = new ElagoPotionRecord(MobEffects.REGENERATION.value(), 2, 22.5, "regeneration_2");
    public static final ElagoPotionRecord SWIFTNESS_1 = new ElagoPotionRecord(MobEffects.MOVEMENT_SPEED.value(), 1, convertMinutesToSeconds(3), "swiftness_1");
    public static final ElagoPotionRecord SWIFTNESS_PLUS = new ElagoPotionRecord(MobEffects.MOVEMENT_SPEED.value(), 1, convertMinutesToSeconds(8), "swiftness_plus");
    public static final ElagoPotionRecord SWIFTNESS_2 = new ElagoPotionRecord(MobEffects.MOVEMENT_SPEED.value(), 2, convertMinutesToSeconds(1, 30), "swiftness_2");
    public static final ElagoPotionRecord FIRE_RESISTANCE = new ElagoPotionRecord(MobEffects.FIRE_RESISTANCE.value(), 1, convertMinutesToSeconds(3), "fire_resistance");
    public static final ElagoPotionRecord FIRE_RESISTANCE_PLUS = new ElagoPotionRecord(MobEffects.FIRE_RESISTANCE.value(), 1, convertMinutesToSeconds(8), "fire_resistance_plus");
    public static final ElagoPotionRecord HEALING_1 = new ElagoPotionRecord(MobEffects.HEAL.value(), 1, 1, "healing_1");
    public static final ElagoPotionRecord HEALING_2 = new ElagoPotionRecord(MobEffects.HEAL.value(), 2, 1, "healing_2");
    public static final ElagoPotionRecord NIGHT_VISION = new ElagoPotionRecord(MobEffects.NIGHT_VISION.value(), 1, convertMinutesToSeconds(3), "night_vision");
    public static final ElagoPotionRecord NIGHT_VISION_PLUS = new ElagoPotionRecord(MobEffects.NIGHT_VISION.value(), 1, convertMinutesToSeconds(8), "night_vision_plus");
    public static final ElagoPotionRecord STRENGTH_1 = new ElagoPotionRecord(MobEffects.DAMAGE_BOOST.value(), 1, convertMinutesToSeconds(3), "strength_1");
    public static final ElagoPotionRecord STRENGTH_PLUS = new ElagoPotionRecord(MobEffects.DAMAGE_BOOST.value(), 1, convertMinutesToSeconds(8), "strength_plus");
    public static final ElagoPotionRecord STRENGTH_2 = new ElagoPotionRecord(MobEffects.DAMAGE_BOOST.value(), 2, convertMinutesToSeconds(1, 30), "strength_2");
    public static final ElagoPotionRecord LEAPING_1 = new ElagoPotionRecord(MobEffects.JUMP.value(), 1, convertMinutesToSeconds(3), "leaping_1");
    public static final ElagoPotionRecord LEAPING_PLUS = new ElagoPotionRecord(MobEffects.JUMP.value(), 1, convertMinutesToSeconds(8), "leaping_plus");
    public static final ElagoPotionRecord LEAPING_2 = new ElagoPotionRecord(MobEffects.JUMP.value(), 2, convertMinutesToSeconds(1, 30), "leaping_2");
    public static final ElagoPotionRecord WATER_BREATHING = new ElagoPotionRecord(MobEffects.WATER_BREATHING.value(), 1, convertMinutesToSeconds(3), "water_breathing");
    public static final ElagoPotionRecord WATER_BREATHING_PLUS = new ElagoPotionRecord(MobEffects.WATER_BREATHING.value(), 1, convertMinutesToSeconds(8), "water_breathing_plus");
    public static final ElagoPotionRecord INVISIBILITY = new ElagoPotionRecord(MobEffects.INVISIBILITY.value(), 1, convertMinutesToSeconds(3), "invisibility");
    public static final ElagoPotionRecord INVISIBILITY_PLUS = new ElagoPotionRecord(MobEffects.INVISIBILITY.value(), 1, convertMinutesToSeconds(8), "invisibility_plus");
    public static final ElagoPotionRecord SLOW_FALLING = new ElagoPotionRecord(MobEffects.SLOW_FALLING.value(), 1, convertMinutesToSeconds(3), "slow_falling");
    public static final ElagoPotionRecord SLOW_FALLING_PLUS = new ElagoPotionRecord(MobEffects.SLOW_FALLING.value(), 1, convertMinutesToSeconds(8), "slow_falling_plus");
    public static final ElagoPotionRecord LUCK = new ElagoPotionRecord(MobEffects.LUCK.value(), 1, convertMinutesToSeconds(5), "luck");
    public static final ElagoPotionRecord POISON_1 = new ElagoPotionRecord(MobEffects.POISON.value(), 1, 45, "poison_1");
    public static final ElagoPotionRecord POISON_PLUS = new ElagoPotionRecord(MobEffects.POISON.value(), 1, convertMinutesToSeconds(1, 30), "poison_plus");
    public static final ElagoPotionRecord POISON_2 = new ElagoPotionRecord(MobEffects.POISON.value(), 2, 22.5, "poison_2");
    public static final ElagoPotionRecord WEAKNESS = new ElagoPotionRecord(MobEffects.WEAKNESS.value(), 1, convertMinutesToSeconds(1, 30), "weakness");
    public static final ElagoPotionRecord WEAKNESS_PLUS = new ElagoPotionRecord(MobEffects.WEAKNESS.value(), 1, convertMinutesToSeconds(4), "weakness_plus");
    public static final ElagoPotionRecord SLOWNESS_1 = new ElagoPotionRecord(MobEffects.MOVEMENT_SLOWDOWN.value(), 1, convertMinutesToSeconds(1, 30), "slowness_1");
    public static final ElagoPotionRecord SLOWNESS_PLUS = new ElagoPotionRecord(MobEffects.MOVEMENT_SLOWDOWN.value(), 1, convertMinutesToSeconds(4), "slowness_plus");
    public static final ElagoPotionRecord SLOWNESS_4 = new ElagoPotionRecord(MobEffects.MOVEMENT_SLOWDOWN.value(), 4,20, "slowness_4");
    public static final ElagoPotionRecord HARMING_1 = new ElagoPotionRecord(MobEffects.HARM.value(), 1, 1, "harming_1");
    public static final ElagoPotionRecord HARMING_2 = new ElagoPotionRecord(MobEffects.HARM.value(), 2, 1, "harming_2");
    public static final ElagoPotionRecord INFESTATION = new ElagoPotionRecord(MobEffects.INFESTED.value(),  1, convertMinutesToSeconds(3), "infestation");
    public static final ElagoPotionRecord OOZING = new ElagoPotionRecord(MobEffects.OOZING.value(), 1, convertMinutesToSeconds(3), "oozing");
    public static final ElagoPotionRecord WEAVING = new ElagoPotionRecord(MobEffects.WEAVING.value(), 1, convertMinutesToSeconds(3), "weaving");
    public static final ElagoPotionRecord WIND_CHARGING = new ElagoPotionRecord(MobEffects.WIND_CHARGED.value(), 1, convertMinutesToSeconds(3), "wind_charged");

    // Turtle Master is a special case, as it applies two effects at once. These need to be applied separately.
    public static final ElagoPotionRecord TURTLE_MASTER_1A = new ElagoPotionRecord(MobEffects.DAMAGE_RESISTANCE.value(), 1, convertMinutesToSeconds(20), "turtle_master_1a");
    public static final ElagoPotionRecord TURTLE_MASTER_1B = new ElagoPotionRecord(MobEffects.MOVEMENT_SLOWDOWN.value(), 1, convertMinutesToSeconds(20), "turtle_master_1b");
    public static final ElagoPotionRecord TURTLE_MASTER_PLUSA = new ElagoPotionRecord(MobEffects.DAMAGE_RESISTANCE.value(), 1, convertMinutesToSeconds(40), "turtle_master_plusa");
    public static final ElagoPotionRecord TURTLE_MASTER_PLUSB = new ElagoPotionRecord(MobEffects.MOVEMENT_SLOWDOWN.value(), 1, convertMinutesToSeconds(40), "turtle_master_plusb");
    public static final ElagoPotionRecord TURTLE_MASTER_2A = new ElagoPotionRecord(MobEffects.DAMAGE_RESISTANCE.value(), 2, convertMinutesToSeconds(20), "turtle_master_2a");
    public static final ElagoPotionRecord TURTLE_MASTER_2B = new ElagoPotionRecord(MobEffects.MOVEMENT_SLOWDOWN.value(), 2, convertMinutesToSeconds(20), "turtle_master_2b");

    /**
     * Utility method to convert minutes to seconds.
     *
     * @param minutes The number of minutes.
     * @return The equivalent number of seconds.
     */
    public static int convertMinutesToSeconds(int minutes) {
        return minutes * 60;
    }

    /**
     * Utility method to convert minutes and additional seconds to total seconds.
     *
     * @param minutes The number of minutes.
     * @param additionalSeconds The additional number of seconds.
     * @return The total equivalent number of seconds.
     */
    public static int convertMinutesToSeconds(int minutes, int additionalSeconds) {
        return minutes * 60 + additionalSeconds;
    }
}
