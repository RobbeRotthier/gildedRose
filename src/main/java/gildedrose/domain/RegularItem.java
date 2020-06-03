package gildedrose.domain;

public class RegularItem extends ItemWrapper {

	public RegularItem(String name, int sellIn, int quality) {
		this(new Item(name, sellIn, quality));
	}

	public RegularItem(Item item) {
		super(item);
	}
}
