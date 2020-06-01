package gildedrose.goods.legendary;

import gildedrose.config.Config;
import gildedrose.goods.Item;

public class SulfurasHand extends Legendary {

	public static final String NAME = "Sulfuras, Hand of Ragnaros";

	public SulfurasHand(int sellIn) {
		this(new Item(NAME, sellIn, Config.LEGENDARY_ITEM_QUALITY));
	}

	public SulfurasHand(Item item) {
		super(item);
	}
}
