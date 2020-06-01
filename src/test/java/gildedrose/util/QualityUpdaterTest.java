package gildedrose.util;

import gildedrose.goods.Item;
import gildedrose.goods.regular.RegularItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityUpdaterTest {

	private final String regular_item = "REGULAR_ITEM";
	private final QualityUpdater qualityUpdater = new QualityUpdater();

	@Test
	void increaseQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		qualityUpdater.increase(item, 1);
		assertEquals(getMaxQuality() - 19, item.getQuality());
	}

	@Test
	void increaseQualityWith5() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		qualityUpdater.increase(item, 5);
		assertEquals(getMaxQuality() - 15, item.getQuality());
	}

	@Test
	void increaseQualityAboveMaxQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality()));

		qualityUpdater.increase(item, 1);
		assertEquals(getMaxQuality(), item.getQuality());
	}

	@Test
	void increaseQualityWith5GoingAboveQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 1));

		qualityUpdater.increase(item, 5);
		assertEquals(getMaxQuality(), item.getQuality());
	}

	@Test
	void decreaseQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		qualityUpdater.decrease(item, 1);
		assertEquals(getMaxQuality() - 21, item.getQuality());
	}

	@Test
	void decreaseQualityWith5() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		qualityUpdater.decrease(item, 5);
		assertEquals(getMaxQuality() - 25, item.getQuality());
	}

	@Test
	void decreaseQualityWith5GoingBelowMinQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 49));

		qualityUpdater.decrease(item, 5);
		assertEquals(getMinQuality(), item.getQuality());
	}

	@Test
	void decreaseQualityBelowMinQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMinQuality()));

		qualityUpdater.decrease(item, 1);
		assertEquals(getMinQuality(), item.getQuality());
	}

	private int getMaxQuality() {
		return qualityUpdater.getMaxQuality();
	}

	private int getMinQuality() {
		return qualityUpdater.getMinQuality();
	}
}
