package gildedrose;

public class GildedRose {
	private final String AGED_BRIE = "Aged Brie";
	private final String SULFURAS_HAND = "Sulfuras, Hand of Ragnaros";
	private final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	private final int MIN_QUALITY = 0;
	private final int MAX_QUALITY = 50;
	private final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASER = 11;
	private final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASER = 6;
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			if (!item.name.equals(AGED_BRIE)
					&& !item.name.equals(BACKSTAGE_PASS)) {
				if (qualityGreaterThanMinQuality(item)) {
					if (!item.name.equals(SULFURAS_HAND)) {
						decreaseQuality(item);
					}
				}
			} else {
				if (qualityLessThanMaxQuality(item)) {
					increaseQuality(item);

					if (item.name.equals(BACKSTAGE_PASS)) {
						if (item.sellIn < BACKSTAGE_PASS_FIRST_QUALITY_INCREASER) {
							if (qualityLessThanMaxQuality(item)) {
								increaseQuality(item);
							}
						}

						if (item.sellIn < BACKSTAGE_PASS_SECOND_QUALITY_INCREASER) {
							if (qualityLessThanMaxQuality(item)) {
								increaseQuality(item);
							}
						}
					}
				}
			}

			if (!item.name.equals(SULFURAS_HAND)) {
				decreaseSellIn(item);
			}

			if (item.sellIn < 0) {
				if (!item.name.equals(AGED_BRIE)) {
					if (!item.name.equals(BACKSTAGE_PASS)) {
						if (qualityGreaterThanMinQuality(item)) {
							if (!item.name.equals(SULFURAS_HAND)) {
								decreaseQuality(item);
							}
						}
					} else {
						item.quality = 0;
					}
				} else {
					if (qualityLessThanMaxQuality(item)) {
						increaseQuality(item);
					}
				}
			}
		}
	}

	private boolean qualityLessThanMaxQuality(Item item) {
		return item.quality < MAX_QUALITY;
	}

	private void decreaseSellIn(Item item) {
		item.sellIn--;
	}

	private boolean qualityGreaterThanMinQuality(Item item) {
		return item.quality > MIN_QUALITY;
	}

	private void increaseQuality(Item item) {
		item.quality++;
	}

	private void decreaseQuality(Item item) {
		item.quality--;
	}
}

