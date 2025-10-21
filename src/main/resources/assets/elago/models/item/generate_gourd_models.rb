# generate_gourd_models.rb
# Generates model JSON files for gourd items: small/medium/large for each potion record.
# Run this script from the command line with `ruby generate_gourd_models.rb`

require 'json'

sizes = %w[small medium large]

records = %w[
  REGENERATION_1 REGENERATION_PLUS REGENERATION_2 SWIFTNESS_1 SWIFTNESS_PLUS SWIFTNESS_2
  FIRE_RESISTANCE FIRE_RESISTANCE_PLUS HEALING_1 HEALING_2 NIGHT_VISION NIGHT_VISION_PLUS
  STRENGTH_1 STRENGTH_PLUS STRENGTH_2 LEAPING_1 LEAPING_PLUS LEAPING_2 WATER_BREATHING
  WATER_BREATHING_PLUS INVISIBILITY INVISIBILITY_PLUS SLOW_FALLING SLOW_FALLING_PLUS LUCK
  POISON_1 POISON_PLUS POISON_2 WEAKNESS WEAKNESS_PLUS SLOWNESS_1 SLOWNESS_PLUS SLOWNESS_4
  HARMING_1 HARMING_2 INFESTATION OOZING WEAVING WIND_CHARGING
]

out_dir = __dir__
created = []

records.each do |rec|
  records_name = rec.downcase
  sizes.each do |size|
    filename = "#{size}_gourd_of_#{records_name}.json"
    path = File.join(out_dir, filename)
    model = {
      'parent' => 'item/generated',
      'textures' => {
        'layer0' => "elago:item/#{size}_bottle_gourd"
      }
    }

    File.open(path, 'w') do |f|
      f.write(JSON.pretty_generate(model))
      f.write("\n")
    end

    created << filename
  end
end

puts "Generated #{created.size} model files in: #{out_dir}"
puts created.join("\n")
