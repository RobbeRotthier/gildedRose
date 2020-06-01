package gildedrose.goods.cheese;

import gildedrose.goods.Item;

public class AgedBrie extends Cheese {

	public static final String NAME = "Aged Brie";

	public AgedBrie(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	public AgedBrie(Item item) {
		super(item);
	}
}
