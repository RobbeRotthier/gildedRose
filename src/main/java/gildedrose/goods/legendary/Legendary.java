package gildedrose.goods.legendary;

import gildedrose.config.Config;
import gildedrose.goods.OurItem;

public class Legendary extends OurItem {

	public Legendary(String name, int sellIn) {
		super(name, sellIn, getLegendaryItemQuality());
	}

	public static int getLegendaryItemQuality() {
		return Config.legendaryItemQuality;
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
