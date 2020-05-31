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
			updateQualityBeforeSellinDays(item);

			endOfDaySellIn(item);

			updateQualityAfterSellInDays(item);
		}
	}

	private void updateQualityAfterSellInDays(Item item) {
		if (item.sellIn < 0) {
			if (!isOfType(item, AGED_BRIE)) {
				if (!isOfType(item, BACKSTAGE_PASS)) {
					if (qualityGreaterThanMinQuality(item)) {
						if (!isOfType(item, SULFURAS_HAND)) {
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

	private void updateQualityBeforeSellinDays(Item item) {
		if (!isOfType(item, AGED_BRIE) && !isOfType(item, BACKSTAGE_PASS)) {
			if (qualityGreaterThanMinQuality(item)) {
				if (!isOfType(item, SULFURAS_HAND)) {
					decreaseQuality(item);
				}
			}
		} else {
			if (qualityLessThanMaxQuality(item)) {
				increaseQuality(item);

				if (isOfType(item, BACKSTAGE_PASS)) {
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
	}

	private boolean isOfType(Item item, String backstage_pass) {
		return item.name.equals(backstage_pass);
	}

	private void endOfDaySellIn(Item item) {
		if (!isOfType(item, SULFURAS_HAND)) {
			decreaseSellIn(item);
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

