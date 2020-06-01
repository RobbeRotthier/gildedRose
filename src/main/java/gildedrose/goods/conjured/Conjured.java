package gildedrose.goods.conjured;

import gildedrose.goods.*;

public abstract class Conjured extends ItemWrapper {

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public Conjured(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		decreaseQuality(2);
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			updateQuality();
		}
	}
}
