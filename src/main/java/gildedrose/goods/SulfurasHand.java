package gildedrose.goods;

public class SulfurasHand extends OurItem {

	public static final String NAME = "Sulfuras, Hand of Ragnaros";
	private static final int sulfurasQuality = 80;//interface? todo

	public SulfurasHand(int sellIn) {
		super(NAME, sellIn, getSulfurasQuality());
	}

	public static int getSulfurasQuality() {
		return sulfurasQuality;
	}

	@Override
	public void atEndOfDay() {
	}

	@Override
	public void updateQuality() {
	}

	@Override
	public void whenSellDatePassed() {
	}
}
