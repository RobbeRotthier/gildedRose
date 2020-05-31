package gildedrose;

import gildedrose.util.QualityUpdater;

public class GildedRose {
	private final String AGED_BRIE = "Aged Brie";
	private final String SULFURAS_HAND = "Sulfuras, Hand of Ragnaros";
	private final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

	private final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASER = 11;
	private final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASER = 6;

	private final QualityUpdater qualityUpdater = new QualityUpdater();
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateQualityBeforeSellInDays(item);
			endOfDaySellIn(item);
			updateQualityAfterSellInDays(item);
		}
	}

	private void updateQualityAfterSellInDays(Item item) {
		if (item.sellIn < 0) {
			if (!isOfType(item, AGED_BRIE)) {
				if (!isOfType(item, BACKSTAGE_PASS)) {
					if (!isOfType(item, SULFURAS_HAND)) {
						decreaseQuality(item);
					}
				} else {
					item.quality = 0;
				}
			} else {
				increaseQuality(item);
			}
		}
	}

	private void endOfDaySellIn(Item item) {
		if (!isOfType(item, SULFURAS_HAND)) {
			decreaseSellIn(item);
		}
	}

	private void updateQualityBeforeSellInDays(Item item) {
		if (!isOfType(item, AGED_BRIE) && !isOfType(item, BACKSTAGE_PASS)) {
			if (!isOfType(item, SULFURAS_HAND)) {
				decreaseQuality(item);
			}
		} else {
			increaseQuality(item);

			if (isOfType(item, BACKSTAGE_PASS)) {
				if (item.sellIn < BACKSTAGE_PASS_FIRST_QUALITY_INCREASER) {
					increaseQuality(item);
				}

				if (item.sellIn < BACKSTAGE_PASS_SECOND_QUALITY_INCREASER) {
					increaseQuality(item);
				}
			}
		}
	}

	private void increaseQuality(Item item) {
		qualityUpdater.increaseQuality(item);
	}

	private void decreaseQuality(Item item) {
		qualityUpdater.decreaseQuality(item);
	}

	private boolean isOfType(Item item, String backstage_pass) {
		return item.name.equals(backstage_pass);
	}

	private void decreaseSellIn(Item item) {
		item.sellIn--;
	}
}

