package gildedrose.factory;

import gildedrose.goods.*;
import gildedrose.goods.backstagepass.Tafkal80EtcConcertBackstagePass;
import gildedrose.goods.cheese.AgedBrie;
import gildedrose.goods.conjured.ConjuredManaCake;
import gildedrose.goods.legendary.SulfurasHand;
import gildedrose.goods.regular.RegularItem;

public class ItemWrapperFactory {

	public ItemInterface createFrom(Item item) {
		return switch (item.name) {
			case AgedBrie.NAME -> new AgedBrie(item);
			case Tafkal80EtcConcertBackstagePass.NAME -> new Tafkal80EtcConcertBackstagePass(item);
			case SulfurasHand.NAME -> new SulfurasHand(item);
			case ConjuredManaCake.NAME -> new ConjuredManaCake(item);
			default -> new RegularItem(item);
		};
	}

	public Item revert(ItemInterface ourItem) {
		return ourItem.getItem();
	}
}
