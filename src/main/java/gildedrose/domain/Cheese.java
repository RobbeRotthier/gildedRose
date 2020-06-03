package gildedrose.domain;

public class Cheese extends ItemWrapper {

	public Cheese(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		increaseQuality(1);
	}

	@Override
	public void whenSellDatePassed() {

	}
}
