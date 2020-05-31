package gildedrose.util;

import gildedrose.goods.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityUpdaterTest {

	private final String regular_item = "REGULAR_ITEM";
	private final QualityUpdater qualityUpdater = new QualityUpdater();

	@Test
	void increaseQuality() {
		var item = new Item(regular_item, 0, getMaxQuality() - 20);

		qualityUpdater.increaseQuality(item);
		assertEquals(getMaxQuality() - 19, item.quality);
	}

	@Test
	void increaseQualityAboveMaxQuality() {
		var item = new Item(regular_item, 0, getMaxQuality());

		qualityUpdater.increaseQuality(item);
		assertEquals(getMaxQuality(), item.quality);
	}

	@Test
	void decreaseQuality() {
		var item = new Item(regular_item, 0, getMaxQuality() - 20);

		qualityUpdater.decreaseQuality(item);
		assertEquals(getMaxQuality() - 21, item.quality);
	}

	@Test
	void decreaseQualityBelowMinQuality() {
		var item = new Item(regular_item, 0, getMinQuality());

		qualityUpdater.decreaseQuality(item);
		assertEquals(getMinQuality(), item.quality);
	}

	private int getMaxQuality() {
		return qualityUpdater.getMaxQuality();
	}

	private int getMinQuality() {
		return qualityUpdater.getMinQuality();
	}
}
