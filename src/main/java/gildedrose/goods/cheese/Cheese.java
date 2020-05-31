package gildedrose.goods.cheese;

import gildedrose.goods.OurItem;

public class Cheese extends OurItem {

	public Cheese(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		increaseQuality();
	}

	@Override
	public void whenSellDatePassed() {

	}
}
