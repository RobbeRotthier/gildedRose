package gildedrose.goods.regular;

import gildedrose.goods.*;

public abstract class Regular extends ItemWrapper {

	public Regular(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public Regular(Item item) {
		super(item);
	}
}
