package gildedrose.factory;

import gildedrose.goods.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OurItemFactoryTest {

	private final OurItemFactory ourItemFactory = new OurItemFactory();

	@Test
	void createFromRegularItem() {
		var item = new Item("name", 1, 2);
		var ourItem = ourItemFactory.createFrom(item);
		assertEquals(ourItem.getClass(), OurItem.class);
		assertEquals(item.quality, ourItem.quality);
		assertEquals(item.name, ourItem.name);
		assertEquals(item.sellIn, ourItem.sellIn);
	}

	@Test
	void createFromConjuredItem() {
		var item = new Item(ConjuredItem.NAME, 1, 2);
		var ourItem = ourItemFactory.createFrom(item);
		assertEquals(ourItem.getClass(), ConjuredItem.class);
		assertEquals(item.quality, ourItem.quality);
		assertEquals(item.name, ourItem.name);
		assertEquals(item.sellIn, ourItem.sellIn);
	}

	@Test
	void createFromSulfurasHandItem() {
		var item = new Item(SulfurasHand.NAME, 1, 2);
		var ourItem = ourItemFactory.createFrom(item);
		assertEquals(ourItem.getClass(), SulfurasHand.class);
		assertEquals(SulfurasHand.getSulfurasQuality(), ourItem.quality);
		assertEquals(item.name, ourItem.name);
		assertEquals(item.sellIn, ourItem.sellIn);
	}

	@Test
	void createFromAgedBrieItem() {
		var item = new Item(AgedBrie.NAME, 1, 2);
		var ourItem = ourItemFactory.createFrom(item);
		assertEquals(ourItem.getClass(), AgedBrie.class);
		assertEquals(item.quality, ourItem.quality);
		assertEquals(item.name, ourItem.name);
		assertEquals(item.sellIn, ourItem.sellIn);
	}

	@Test
	void createFromAgedBackStagePassItem() {
		var item = new Item(BackStagePass.NAME, 1, 2);
		var ourItem = ourItemFactory.createFrom(item);
		assertEquals(ourItem.getClass(), BackStagePass.class);
		assertEquals(item.quality, ourItem.quality);
		assertEquals(item.name, ourItem.name);
		assertEquals(item.sellIn, ourItem.sellIn);
	}

	@Test
	void revertRegularItem() {
		var ourItem = new OurItem("name", 1, 2);
		var item = ourItemFactory.revert(ourItem);
		assertEquals(ourItem.quality, item.quality);
		assertEquals(ourItem.name, item.name);
		assertEquals(ourItem.sellIn, item.sellIn);
	}

	@Test
	void revertAgedBrieItem() {
		var ourItem = new AgedBrie(1, 2);
		var item = ourItemFactory.revert(ourItem);
		assertEquals(ourItem.quality, item.quality);
		assertEquals(ourItem.name, item.name);
		assertEquals(ourItem.sellIn, item.sellIn);
	}

	@Test
	void revertSulfurasHandItem() {
		var ourItem = new SulfurasHand(2);
		var item = ourItemFactory.revert(ourItem);
		assertEquals(ourItem.quality, item.quality);
		assertEquals(ourItem.name, item.name);
		assertEquals(ourItem.sellIn, item.sellIn);
	}

	@Test
	void revertBackStagePassItem() {
		var ourItem = new BackStagePass(1, 2);
		var item = ourItemFactory.revert(ourItem);
		assertEquals(ourItem.quality, item.quality);
		assertEquals(ourItem.name, item.name);
		assertEquals(ourItem.sellIn, item.sellIn);
	}

	@Test
	void revertConjuredItem() {
		var ourItem = new ConjuredItem(1, 2);
		var item = ourItemFactory.revert(ourItem);
		assertEquals(ourItem.quality, item.quality);
		assertEquals(ourItem.name, item.name);
		assertEquals(ourItem.sellIn, item.sellIn);
	}
}
