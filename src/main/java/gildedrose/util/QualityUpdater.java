package gildedrose.util;

import gildedrose.config.Config;
import gildedrose.goods.ItemWrapper;

public class QualityUpdater {

	public void increase(ItemWrapper itemWrapper, int amount) {
		itemWrapper.setQuality(Math.min(itemWrapper.getQuality() + amount, getMaxQuality()));
	}

	public void decrease(ItemWrapper itemWrapper, int amount) {
		itemWrapper.setQuality(Math.max(itemWrapper.getQuality() - amount, getMinQuality()));
	}

	public int getMinQuality() {
		return Config.MIN_QUALITY;
	}

	public int getMaxQuality() {
		return Config.MAX_QUALITY;
	}
}
