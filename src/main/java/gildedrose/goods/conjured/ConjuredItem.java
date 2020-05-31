package gildedrose.goods.conjured;

import gildedrose.goods.OurItem;

public class ConjuredItem extends OurItem {

	public ConjuredItem(String name, int sellIn, int quality) {
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
