package gildedrose.domain.factory;

import gildedrose.domain.*;

public class ItemWrapperFactory {

	public static final String BACKSTAGEPASS = "Backstage passes to a TAFKAL80ETC concert";
	public static final String CONJURED = "Conjured Mana Cake";
	public static final String AGED_BRIE = "Aged Brie";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

	public ItemInterface createFrom(Item item) {
		return switch (item.name) {
			case AGED_BRIE -> new Cheese(item);
			case BACKSTAGEPASS -> new BackstagePass(item);
			case SULFURAS -> new Legendary(item);
			case CONJURED -> new Conjured(item);
			default -> new RegularItem(item);
		};
	}

	public Item revert(ItemInterface ourItem) {
		return ourItem.getItem();
	}
}
