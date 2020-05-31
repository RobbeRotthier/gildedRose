package gildedrose.goods;

public class AgedBrie extends OurItem {

	public static final String NAME = "Aged Brie";

	public AgedBrie(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		increaseQuality();
	}

	@Override
	public void whenSellDatePassed() {

	}
}
