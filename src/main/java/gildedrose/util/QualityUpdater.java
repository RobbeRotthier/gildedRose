package gildedrose.util;

import gildedrose.config.Config;
import gildedrose.goods.ItemWrapper;

public class QualityUpdater {

	public void increase(ItemWrapper item, int amount) {
		item.setQuality(Math.min(item.getQuality() + amount, getMaxQuality()));
	}

	public void decrease(ItemWrapper item, int amount) {
		item.setQuality(Math.max(item.getQuality() - amount, getMinQuality()));
	}

	public int getMinQuality() {
		return Config.MIN_QUALITY;
	}

	public int getMaxQuality() {
		return Config.MAX_QUALITY;
	}
}
