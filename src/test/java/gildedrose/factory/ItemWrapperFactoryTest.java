package gildedrose.factory;

import gildedrose.config.Config;
import gildedrose.domain.*;
import gildedrose.domain.factory.ItemWrapperFactory;
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
		var item = new Item(ItemWrapperFactory.CONJURED, 1, 2);
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), Conjured.class);
		assertEquals(item.quality, ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void createFromSulfurasHandItem() {
		var item = new Item(ItemWrapperFactory.SULFURAS, 1, Legendary.getLegendaryItemQuality());
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), Legendary.class);
		assertEquals(Legendary.getLegendaryItemQuality(), ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void createFromAgedBrieItem() {
		var item = new Item(ItemWrapperFactory.AGED_BRIE, 1, 2);
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), Cheese.class);
		assertEquals(item.quality, ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void createFromAgedBackStagePassItem() {
		var item = new Item(ItemWrapperFactory.BACKSTAGEPASS, 1, 2);
		var ourItem = itemWrapperFactory.createFrom(item);
		assertEquals(ourItem.getClass(), BackstagePass.class);
		assertEquals(item.quality, ourItem.getQuality());
		assertEquals(item.name, ourItem.getName());
		assertEquals(item.sellIn, ourItem.getSellIn());
	}

	@Test
	void revertRegularItem() {
		var regularItem = new RegularItem("name", 1, 2);
		var item = itemWrapperFactory.revert(regularItem);
		assertEquals(regularItem.getQuality(), item.quality);
		assertEquals(regularItem.getName(), item.name);
		assertEquals(regularItem.getSellIn(), item.sellIn);
	}

	@Test
	void revertCheeseItem() {
		Cheese aged_brie = new Cheese(new Item(ItemWrapperFactory.AGED_BRIE, 1, 2));
		var item = itemWrapperFactory.revert(aged_brie);
		assertEquals(aged_brie.getQuality(), item.quality);
		assertEquals(aged_brie.getName(), item.name);
		assertEquals(aged_brie.getSellIn(), item.sellIn);
	}

	@Test
	void revertLegendaryItem() {
		Legendary legendary = new Legendary(new Item(ItemWrapperFactory.SULFURAS, 1, Config.LEGENDARY_ITEM_QUALITY));
		var item = itemWrapperFactory.revert(legendary);
		assertEquals(legendary.getQuality(), item.quality);
		assertEquals(legendary.getName(), item.name);
		assertEquals(legendary.getSellIn(), item.sellIn);
	}

	@Test
	void revertBackStagePassItem() {
		BackstagePass legendary = new BackstagePass(new Item(ItemWrapperFactory.BACKSTAGEPASS, 1, 2));
		var item = itemWrapperFactory.revert(legendary);
		assertEquals(legendary.getQuality(), item.quality);
		assertEquals(legendary.getName(), item.name);
		assertEquals(legendary.getSellIn(), item.sellIn);
	}

	@Test
	void revertConjuredItem() {
		Conjured conjured = new Conjured(new Item(ItemWrapperFactory.CONJURED, 1, 2));
		var item = itemWrapperFactory.revert(conjured);
		assertEquals(conjured.getQuality(), item.quality);
		assertEquals(conjured.getName(), item.name);
		assertEquals(conjured.getSellIn(), item.sellIn);
	}
}
