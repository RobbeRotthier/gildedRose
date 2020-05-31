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
				if (item.quality > MIN_QUALITY) {
					if (!item.name.equals(SULFURAS_HAND)) {
						item.quality = item.quality - 1;
					}
				}
			} else {
				if (item.quality < MAX_QUALITY) {
					item.quality = item.quality + 1;

					if (item.name.equals(BACKSTAGE_PASS)) {
						if (item.sellIn < BACKSTAGE_PASS_FIRST_QUALITY_INCREASER) {
							if (item.quality < MAX_QUALITY) {
								item.quality = item.quality + 1;
							}
						}

						if (item.sellIn < BACKSTAGE_PASS_SECOND_QUALITY_INCREASER) {
							if (item.quality < MAX_QUALITY) {
								item.quality = item.quality + 1;
							}
						}
					}
				}
			}

			if (!item.name.equals(SULFURAS_HAND)) {
				item.sellIn = item.sellIn - 1;
			}

			if (item.sellIn < 0) {
				if (!item.name.equals(AGED_BRIE)) {
					if (!item.name.equals(BACKSTAGE_PASS)) {
						if (item.quality > MIN_QUALITY) {
							if (!item.name.equals(SULFURAS_HAND)) {
								item.quality = item.quality - 1;
							}
						}
					} else {
						item.quality = item.quality - item.quality;
					}
				} else {
					if (item.quality < MAX_QUALITY) {
						item.quality = item.quality + 1;
					}
				}
			}
		}
	}
}

