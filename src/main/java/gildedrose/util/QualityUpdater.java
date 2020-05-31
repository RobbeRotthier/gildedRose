package gildedrose.util;

import gildedrose.goods.Item;

public class QualityUpdater {

	private final int MIN_QUALITY = 0;
	private final int MAX_QUALITY = 50;

	public void increaseQuality(Item item) {
		if (qualityLessThanMaxQuality(item)) {
			item.quality++;
		}
	}

	public void decreaseQuality(Item item) {
		if (qualityGreaterThanMinQuality(item)) {
			item.quality--;
		}
	}

	private boolean qualityLessThanMaxQuality(Item item) {
		return item.quality < getMaxQuality();
	}

	private boolean qualityGreaterThanMinQuality(Item item) {
		return item.quality > getMinQuality();
	}

	public int getMinQuality() {
		return MIN_QUALITY;
	}

	public int getMaxQuality() {
		return MAX_QUALITY;
	}
}
