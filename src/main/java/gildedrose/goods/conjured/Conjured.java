package gildedrose.goods.conjured;

import gildedrose.goods.OurItem;

public class Conjured extends OurItem {

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		decreaseQuality();
		decreaseQuality();
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			updateQuality();
		}
	}
}
