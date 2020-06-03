package gildedrose.domain.util;

import gildedrose.config.Config;
import gildedrose.domain.ItemWrapper;

public class QualityUpdater {
	private QualityUpdater() {
	}

	public static void increase(ItemWrapper itemWrapper, int amount) {
		itemWrapper.setQuality(Math.min(itemWrapper.getQuality() + amount, getMaxQuality()));
	}

	public static void decrease(ItemWrapper itemWrapper, int amount) {
		itemWrapper.setQuality(Math.max(itemWrapper.getQuality() - amount, getMinQuality()));
	}

	public static int getMinQuality() {
		return Config.MIN_QUALITY;
	}

	public static int getMaxQuality() {
		return Config.MAX_QUALITY;
	}
}
