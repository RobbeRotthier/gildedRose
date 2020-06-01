package gildedrose.goods.legendary;

import gildedrose.config.Config;
import gildedrose.goods.*;

public abstract class Legendary extends ItemWrapper {

	public Legendary(String name, int sellIn) {
		super(name, sellIn, getLegendaryItemQuality());
	}

	public Legendary(Item item) {
		super(item);
	}

	public static int getLegendaryItemQuality() {
		return Config.LEGENDARY_ITEM_QUALITY;
	}

	@Override
	public void atEndOfDay() {
	}

	@Override
	public void updateQuality() {
	}

	@Override
	public void whenSellDatePassed() {
	}
}
