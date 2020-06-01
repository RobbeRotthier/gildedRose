package gildedrose.goods.conjured;

import gildedrose.goods.Item;

public class ConjuredManaCake extends Conjured {
	public static final String NAME = "Conjured Mana Cake";

	public ConjuredManaCake(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	public ConjuredManaCake(Item item) {
		super(item);
	}
}
