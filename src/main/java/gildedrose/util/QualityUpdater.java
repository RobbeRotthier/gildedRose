package gildedrose.util;

import gildedrose.config.Config;
import gildedrose.goods.Item;

public class QualityUpdater {

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
		return Config.MIN_QUALITY;
	}

	public int getMaxQuality() {
		return Config.MAX_QUALITY;
	}
}
