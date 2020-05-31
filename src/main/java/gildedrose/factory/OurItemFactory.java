package gildedrose.factory;

import gildedrose.goods.*;

public class OurItemFactory {

	public OurItem createFrom(Item item) {
		return switch (item.name) {
			case AgedBrie.NAME -> new AgedBrie(item.sellIn, item.quality);
			case BackStagePass.NAME -> new BackStagePass(item.sellIn, item.quality);
			case SulfurasHand.NAME -> new SulfurasHand(item.sellIn);
			case ConjuredItem.NAME -> new ConjuredItem(item.sellIn, item.quality);
			default -> new OurItem(item.name, item.sellIn, item.quality);
		};
	}

	public Item revert(OurItem ourItem) {
		return new Item(ourItem.name, ourItem.sellIn, ourItem.quality);
	}
}
