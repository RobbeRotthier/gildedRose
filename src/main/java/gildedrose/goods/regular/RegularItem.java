package gildedrose.goods.regular;

import gildedrose.goods.Item;

public class RegularItem extends Regular {

	public RegularItem(String name, int sellIn, int quality) {
		this(new Item(name, sellIn, quality));
	}

	public RegularItem(Item item) {
		super(item);
	}
}
