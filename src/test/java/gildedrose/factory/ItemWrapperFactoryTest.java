package gildedrose.factory;

import gildedrose.goods.Item;
import gildedrose.goods.backstagepass.Tafkal80EtcConcertBackstagePass;
import gildedrose.goods.cheese.AgedBrie;
import gildedrose.goods.conjured.ConjuredManaCake;
import gildedrose.goods.legendary.*;
import gildedrose.goods.regular.RegularItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemWrapperFactoryTest {

	private final ItemWrapperFactory itemWrapperFactory = new ItemWrapperFactory();

	@Test
	void createFromItem() {
		var item = new Item("name", 1, 2);
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), RegularItem.class);
		assertEquals(item.quality, ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void createFromConjuredItem() {
		var item = new Item(ConjuredManaCake.NAME, 1, 2);
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), ConjuredManaCake.class);
		assertEquals(item.quality, ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void createFromSulfurasHandItem() {
		var item = new Item(SulfurasHand.NAME, 1, Legendary.getLegendaryItemQuality());
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), SulfurasHand.class);
		assertEquals(Legendary.getLegendaryItemQuality(), ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void createFromAgedBrieItem() {
		var item = new Item(AgedBrie.NAME, 1, 2);
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), AgedBrie.class);
		assertEquals(item.quality, ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void createFromAgedBackStagePassItem() {
		var item = new Item(Tafkal80EtcConcertBackstagePass.NAME, 1, 2);
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), Tafkal80EtcConcertBackstagePass.class);
		assertEquals(item.quality, ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void revertRegularItem() {
		var ourItem = new RegularItem("name", 1, 2);
		var item = itemWrapperFactory.revert(ourItem);
		assertEquals(ourItem.getQuality(), item.quality);
		assertEquals(ourItem.getName(), item.name);
		assertEquals(ourItem.getSellIn(), item.sellIn);
	}

	@Test
	void revertAgedBrieItem() {
		AgedBrie ourItem = new AgedBrie(1, 2);
		var item = itemWrapperFactory.revert(ourItem);
		assertEquals(ourItem.getQuality(), item.quality);
		assertEquals(ourItem.getName(), item.name);
		assertEquals(ourItem.getSellIn(), item.sellIn);
	}

	@Test
	void revertSulfurasHandItem() {
		SulfurasHand ourItem = new SulfurasHand(2);
		var item = itemWrapperFactory.revert(ourItem);
		assertEquals(ourItem.getQuality(), item.quality);
		assertEquals(ourItem.getName(), item.name);
		assertEquals(ourItem.getSellIn(), item.sellIn);
	}

	@Test
	void revertBackStagePassItem() {
		Tafkal80EtcConcertBackstagePass ourItem = new Tafkal80EtcConcertBackstagePass(1, 2);
		var item = itemWrapperFactory.revert(ourItem);
		assertEquals(ourItem.getQuality(), item.quality);
		assertEquals(ourItem.getName(), item.name);
		assertEquals(ourItem.getSellIn(), item.sellIn);
	}

	@Test
	void revertConjuredItem() {
		ConjuredManaCake ourItem = createConjuredManaCake();
		var item = itemWrapperFactory.revert(ourItem);
		assertEquals(ourItem.getQuality(), item.quality);
		assertEquals(ourItem.getName(), item.name);
		assertEquals(ourItem.getSellIn(), item.sellIn);
	}

	private ConjuredManaCake createConjuredManaCake() {
		return new ConjuredManaCake(1, 2);
	}
}
