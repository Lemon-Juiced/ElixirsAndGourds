# generate_gourd_lang.rb
# Prints lang entries for gourd items to stdout in the style of the examples.
# Run: ruby generate_gourd_lang.rb

sizes = %w[small medium large]

records = %w[
  REGENERATION_1 REGENERATION_PLUS REGENERATION_2 SWIFTNESS_1 SWIFTNESS_PLUS SWIFTNESS_2
  FIRE_RESISTANCE FIRE_RESISTANCE_PLUS HEALING_1 HEALING_2 NIGHT_VISION NIGHT_VISION_PLUS
  STRENGTH_1 STRENGTH_PLUS STRENGTH_2 LEAPING_1 LEAPING_PLUS LEAPING_2 WATER_BREATHING
  WATER_BREATHING_PLUS INVISIBILITY INVISIBILITY_PLUS SLOW_FALLING SLOW_FALLING_PLUS LUCK
  POISON_1 POISON_PLUS POISON_2 WEAKNESS WEAKNESS_PLUS SLOWNESS_1 SLOWNESS_PLUS SLOWNESS_4
  HARMING_1 HARMING_2 INFESTATION OOZING WEAVING WIND_CHARGING
]

# Additional explicit turtle master variants (these were hand-declared in the codebase)
extras = %w[
  the_turtle_master_1 the_turtle_master_plus the_turtle_master_2
]

# Helper to convert arabic number string to simple roman numerals (1-10 supported)
def to_roman(n_str)
  mapping = { '1' => 'I', '2' => 'II', '3' => 'III', '4' => 'IV', '5' => 'V', '6' => 'VI', '7' => 'VII', '8' => 'VIII', '9' => 'IX', '10' => 'X' }
  mapping[n_str] || n_str
end

# Convert a record token like 'regeneration_1' or 'the_turtle_master_plus' to a human-friendly phrase
def humanize_record(token)
  parts = token.downcase.split('_')
  suffix = nil

  if parts.last == 'plus'
    suffix = '+'
    parts.pop
  elsif parts.last =~ /^\d+$/
    suffix = to_roman(parts.last)
    parts.pop
  end

  # Title-case most words, but keep small words lowercase; we'll adjust 'the' after 'of' specifically
  small_words = %w[the a an of and]
  words = parts.each_with_index.map do |w, i|
    if small_words.include?(w) && i != 0
      w
    else
      w.capitalize
    end
  end

  base = words.join(' ')

  # When used after 'of', prefer 'the' lowercase (example: "Small Gourd of the Turtle Master I")
  if base.start_with?('The ')
    base = base.sub(/^The /, 'the ')
  end

  if suffix
    # For roman numerals, include a space before; for '+' include a space too
    base + ' ' + suffix
  else
    base
  end
end

entries = []

# Generate for main records
records.each do |rec|
  rec_key = rec.downcase
  human = humanize_record(rec_key)
  sizes.each do |size|
    key = "item.elago.#{size}_gourd_of_#{rec_key}"
    value = "#{size.capitalize} Gourd of #{human}"
    entries << [key, value]
  end
end

# Generate for explicit extra/turtle-master keys
extras.each do |rec_key|
  human = humanize_record(rec_key)
  sizes.each do |size|
    key = "item.elago.#{size}_gourd_of_#{rec_key}"
    value = "#{size.capitalize} Gourd of #{human}"
    entries << [key, value]
  end
end

# Print entries to console (JSON-ish lines)
entries.each do |k, v|
  puts "\"#{k}\": \"#{v}\","
end

# Optionally, print count
STDERR.puts "Generated #{entries.size} entries"
