package gildedrose.factory;

import gildedrose.goods.*;
import gildedrose.goods.backstagepass.Tafkal80EtcConcertBackstagePass;
import gildedrose.goods.cheese.AgedBrie;
import gildedrose.goods.conjured.ConjuredManaCake;
import gildedrose.goods.legendary.SulfurasHand;

public class OurItemFactory {

	public ItemInterface createFrom(Item item) {
		return switch (item.name) {
			case AgedBrie.NAME -> new AgedBrie(item.sellIn, item.quality);
			case Tafkal80EtcConcertBackstagePass.NAME -> new Tafkal80EtcConcertBackstagePass(item.sellIn, item.quality);
			case SulfurasHand.NAME -> new SulfurasHand(item.sellIn);
			case ConjuredManaCake.NAME -> new ConjuredManaCake(item.sellIn, item.quality);
			default -> new OurItem(item.name, item.sellIn, item.quality);
		};
	}

	public Item revert(ItemInterface ourItem) {
		return new Item(ourItem.getName(), ourItem.getSellIn(), ourItem.getQuality());
	}
}
