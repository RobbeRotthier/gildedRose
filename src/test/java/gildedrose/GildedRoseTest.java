package gildedrose;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
	private final String SULFARAS = "Sulfuras, Hand of Ragnaros";
	private final String AGED_BRIE = "Aged Brie";
	private final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	private final String REGULAR_ITEM = "some item";
	private final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

	@Test
	void foo() {
		Item[] items = new Item[]{new Item("fixme", 0, 0)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("fixme", app.items[0].name);
	}

	@Test
	void nameDoesNotChangeOnUpdateQuality() {
		Item[] items = new Item[]{new Item(REGULAR_ITEM, 20, 50), new Item(AGED_BRIE, 2, 12), new Item(SULFARAS, 2, 12), new Item(CONJURED_MANA_CAKE, 2, 12)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		checkName(REGULAR_ITEM, app.items[0]);
		checkName(AGED_BRIE, app.items[1]);
		checkName(SULFARAS, app.items[2]);
		checkName(CONJURED_MANA_CAKE, app.items[3]);
	}

	private void checkName(String agedBrie, Item item) {
		assertEquals(agedBrie, item.name);
	}

	@Test
	void qualityLowersByOneForNormalItem() {
		Item[] items = new Item[]{new Item(REGULAR_ITEM, 20, 50)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(49, app.items[0].quality);
		app.updateQuality();
		assertEquals(48, app.items[0].quality);
	}

	@Test
	void sellInLowersByOneForNormalItem() {
		Item[] items = new Item[]{new Item(REGULAR_ITEM, 20, 50)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(19, app.items[0].sellIn);
		app.updateQuality();
		assertEquals(18, app.items[0].sellIn);
	}

	@Test
	void minQualityIs0() {
		Item[] items = new Item[]{new Item(REGULAR_ITEM, 2, 1)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(0, app.items[0].quality);
		assertEquals(1, app.items[0].sellIn);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
	}

	@Test
	void sellDatePassedQualityDegradesTwiceAsFast() {
		Item[] items = new Item[]{new Item(REGULAR_ITEM, 1, 50)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(0, app.items[0].sellIn);
		assertEquals(49, app.items[0].quality);

		app.updateQuality();
		assertEquals(-1, app.items[0].sellIn);
		assertEquals(47, app.items[0].quality);
	}

	@Test
	void agedBrieIncreasesQuality() {
		Item[] items = new Item[]{new Item(AGED_BRIE, 2, 12)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(13, app.items[0].quality);
		assertEquals(1, app.items[0].sellIn);

		app.updateQuality();
		assertEquals(14, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
	}

	@Test
	void agedBrieHasMaxQualityOf50() {
		Item[] items = new Item[]{new Item(AGED_BRIE, 2, 49)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(50, app.items[0].quality);
		assertEquals(1, app.items[0].sellIn);

		app.updateQuality();
		assertEquals(50, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
		app.updateQuality();
		assertEquals(50, app.items[0].quality);
		assertEquals(-1, app.items[0].sellIn);
	}

	@Test
	void backstagePassHasMaxQualityOf50() {
		Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 2, 49)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(50, app.items[0].quality);
		assertEquals(1, app.items[0].sellIn);

		app.updateQuality();
		assertEquals(50, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);
	}

	@Test
	void backStagePassIncreaseQualityPlus2WhenSellInLessThan10Days() {
		Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 11, 30)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(31, app.items[0].quality);
		assertEquals(10, app.items[0].sellIn);

		app.updateQuality();
		assertEquals(33, app.items[0].quality);
		assertEquals(9, app.items[0].sellIn);
	}

	@Test
	void backStagePassIncreaseQualityPlus3WhenSellInLessThan5Days() {
		Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 6, 30)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(32, app.items[0].quality);
		assertEquals(5, app.items[0].sellIn);

		app.updateQuality();
		assertEquals(35, app.items[0].quality);
		assertEquals(4, app.items[0].sellIn);
	}

	@Test
	void backStagePassQualityBecomesZeroAfterConcertDate() {
		Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 1, 30)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(33, app.items[0].quality);
		assertEquals(0, app.items[0].sellIn);

		app.updateQuality();
		assertEquals(0, app.items[0].quality);
		assertEquals(-1, app.items[0].sellIn);
	}

	@Test
	void sulfarasNeverDecreasesInSellIn() {
		Item[] items = new Item[]{new Item(SULFARAS, 1, 80)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(1, app.items[0].sellIn);
	}

	@Test
	void sulfarasNeverDecreasesInQuality() {
		Item[] items = new Item[]{new Item(SULFARAS, 1, 80)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(80, app.items[0].quality);
	}

	@Test
	@Disabled("conjured flow not implemented")
	void conjuredItemsDegradeTwiceAsFastAsNormalItems() {
		Item[] items = new Item[]{new Item(CONJURED_MANA_CAKE, 21, 30)};
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertEquals(28, app.items[0].quality);
		assertEquals(20, app.items[0].sellIn);

		app.updateQuality();
		assertEquals(26, app.items[0].quality);
		assertEquals(19, app.items[0].sellIn);
	}
}
