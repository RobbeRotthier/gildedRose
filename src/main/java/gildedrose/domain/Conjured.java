package gildedrose.domain;

public class Conjured extends ItemWrapper {

	public Conjured(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		decreaseQuality(2);
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			updateQuality();
		}
	}
}
