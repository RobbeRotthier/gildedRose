package gildedrose.util;

import gildedrose.domain.*;
import gildedrose.domain.util.QualityUpdater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityUpdaterTest {

	private final String regular_item = "REGULAR_ITEM";

	@Test
	void increaseQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		QualityUpdater.increase(item, 1);
		assertEquals(getMaxQuality() - 19, item.getQuality());
	}

	@Test
	void increaseQualityWith5() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		QualityUpdater.increase(item, 5);
		assertEquals(getMaxQuality() - 15, item.getQuality());
	}

	@Test
	void increaseQualityAboveMaxQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality()));

		QualityUpdater.increase(item, 1);
		assertEquals(getMaxQuality(), item.getQuality());
	}

	@Test
	void increaseQualityWith5GoingAboveQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 1));

		QualityUpdater.increase(item, 5);
		assertEquals(getMaxQuality(), item.getQuality());
	}

	@Test
	void decreaseQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		QualityUpdater.decrease(item, 1);
		assertEquals(getMaxQuality() - 21, item.getQuality());
	}

	@Test
	void decreaseQualityWith5() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 20));

		QualityUpdater.decrease(item, 5);
		assertEquals(getMaxQuality() - 25, item.getQuality());
	}

	@Test
	void decreaseQualityWith5GoingBelowMinQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMaxQuality() - 49));

		QualityUpdater.decrease(item, 5);
		assertEquals(getMinQuality(), item.getQuality());
	}

	@Test
	void decreaseQualityBelowMinQuality() {
		var item = new RegularItem(new Item(regular_item, 0, getMinQuality()));

		QualityUpdater.decrease(item, 1);
		assertEquals(getMinQuality(), item.getQuality());
	}

	private int getMaxQuality() {
		return QualityUpdater.getMaxQuality();
	}

	private int getMinQuality() {
		return QualityUpdater.getMinQuality();
	}
}
