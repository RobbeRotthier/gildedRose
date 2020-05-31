package gildedrose.goods;

public class ConjuredItem extends OurItem {
	public static final String NAME = "Conjured Mana Cake";

	public ConjuredItem(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		decreaseQuality();
		decreaseQuality();
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			updateQuality();
		}
	}
}
