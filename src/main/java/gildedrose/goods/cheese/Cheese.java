package gildedrose.goods.cheese;

import gildedrose.goods.*;

public abstract class Cheese extends ItemWrapper {

	public Cheese(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public Cheese(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		increaseQuality(1);
	}

	@Override
	public void whenSellDatePassed() {

	}
}
