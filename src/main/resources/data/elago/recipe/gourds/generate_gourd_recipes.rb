# generate_gourd_recipes.rb
# Generates shapeless crafting recipes for size bottle + reagent -> sized gourd_of_<effect>.
# Rules applied:
#  - Tokens ending with _PLUS -> reagent: minecraft:redstone
#  - Tokens ending with _2 -> reagent: minecraft:glowstone_dust
#  - Otherwise map the base effect name to the reagent using `base_map` below
#  - Leading `THE_` is removed for tokens like THE_TURTLE_MASTER_1
# Run: ruby generate_gourd_recipes.rb

require 'json'

sizes = %w[small medium large]

records = %w[
  REGENERATION_1 REGENERATION_PLUS REGENERATION_2 SWIFTNESS_1 SWIFTNESS_PLUS SWIFTNESS_2
  FIRE_RESISTANCE FIRE_RESISTANCE_PLUS HEALING_1 HEALING_2 NIGHT_VISION NIGHT_VISION_PLUS
  STRENGTH_1 STRENGTH_PLUS STRENGTH_2 LEAPING_1 LEAPING_PLUS LEAPING_2 WATER_BREATHING
  WATER_BREATHING_PLUS INVISIBILITY INVISIBILITY_PLUS SLOW_FALLING SLOW_FALLING_PLUS LUCK
  POISON_1 POISON_PLUS POISON_2 WEAKNESS WEAKNESS_PLUS SLOWNESS_1 SLOWNESS_PLUS SLOWNESS_4
  HARMING_1 HARMING_2 INFESTATION OOZING WEAVING WIND_CHARGING
  THE_TURTLE_MASTER_1 THE_TURTLE_MASTER_PLUS THE_TURTLE_MASTER_2
]

# Exact reagent mapping provided by the user
base_map = {
  'night_vision'    => 'minecraft:golden_carrot',        # Night Vision
  'invisibility'    => 'minecraft:fermented_spider_eye', # Invisibility (also used for some inversions)
  'leaping'         => 'minecraft:rabbit_foot',          # Leaping
  'fire_resistance' => 'minecraft:magma_cream',          # Fire Resistance
  'swiftness'       => 'minecraft:sugar',                # Swiftness
  'slowness'        => 'minecraft:fermented_spider_eye', # Slowness (inversions: swiftness/leaping)
  'turtle_master'   => 'minecraft:turtle_helmet',        # Turtle Master
  'water_breathing' => 'minecraft:pufferfish',           # Water Breathing
  'healing'         => 'minecraft:glistering_melon_slice', # Healing
  'harming'         => 'minecraft:fermented_spider_eye', # Harming (inversions: poison/healing)
  'poison'          => 'minecraft:spider_eye',          # Poison
  'regeneration'    => 'minecraft:ghast_tear',          # Regeneration
  'strength'        => 'minecraft:blaze_powder',        # Strength
  'weakness'        => 'minecraft:fermented_spider_eye',# Weakness
  'slow_falling'    => 'minecraft:phantom_membrane',    # Slow Falling
  'wind_charging'   => 'elago:breeze_rod',              # Wind Charging (mod item)
  'weaving'         => 'minecraft:cobweb',              # Weaving
  'oozing'          => 'minecraft:slime_block',         # Oozing
  'infestation'     => 'minecraft:stone',               # Infestation
  'luck'            => nil                              # No reagent provided for luck; will be skipped
}

out_dir = __dir__
created = []
skipped = []

# Determine ingredients for a token like 'REGENERATION_1' or 'POISON_PLUS'
def ingredients_for(token, base_map)
  t = token.downcase

  # Strip any trailing numeric suffix or _plus to lookup the base reagent
  base = t.sub(/_(\d+)$/, '')
  base = base.sub(/_plus$/, '')
  base = base.sub(/^the_/, '')

  base_reagent = base_map[base]
  return nil if base_reagent.nil?

  ingredients = [base_reagent]

  # PLUS -> add redstone
  ingredients << 'minecraft:redstone' if t.end_with?('_plus')

  # Numeric suffix (including _2) -> add glowstone_dust
  if t =~ /_(\d+)$/
    ingredients << 'minecraft:glowstone_dust'
  end

  ingredients
end

# Build recipes
records.each do |rec|
  rec_key = rec.downcase
  sizes.each do |size|
    reagents = ingredients_for(rec, base_map)

    if reagents.nil? || reagents.empty?
      STDERR.puts "Skipping #{size}_gourd_of_#{rec_key}: no reagent mapping (please provide one in base_map)"
      skipped << "#{size}_gourd_of_#{rec_key}"
      next
    end

    ingredient_objs = [{ 'item' => "elago:#{size}_bottle_gourd" }] + reagents.map { |r| { 'item' => r } }

    recipe = {
      'type' => 'minecraft:crafting_shapeless',
      'ingredients' => ingredient_objs,
      'result' => { 'id' => "elago:#{size}_gourd_of_#{rec_key}", 'count' => 1 }
    }

    filename = "#{size}_gourd_of_#{rec_key}.json"
    path = File.join(out_dir, filename)
    File.open(path, 'w') do |f|
      f.write(JSON.pretty_generate(recipe))
      f.write("\n")
    end

    created << filename
  end
end

puts "Generated #{created.size} recipes in: #{out_dir}"
puts created.join("\n")
unless skipped.empty?
  STDERR.puts "Skipped #{skipped.size} recipes:"
  skipped.each { |s| STDERR.puts "  - #{s}" }
end
