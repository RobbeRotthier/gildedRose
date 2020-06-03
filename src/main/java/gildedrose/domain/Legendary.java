package gildedrose.domain;

import gildedrose.config.Config;

public class Legendary extends ItemWrapper {

	public Legendary(Item item) {
		super(item);
	}

	public static int getLegendaryItemQuality() {
		return Config.LEGENDARY_ITEM_QUALITY;
	}

	@Override
	public void updateSellIn() {
	}

	@Override
	public void updateQuality() {
	}

	@Override
	public void whenSellDatePassed() {
	}
}
