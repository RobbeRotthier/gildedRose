package gildedrose.goods;

public class SulfurasHand extends OurItem {

	private static final String NAME = "Sulfuras, Hand of Ragnaros";

	public SulfurasHand(int sellIn, int quality) {
		super(getName(), sellIn, quality);
	}

	public static String getName() {
		return NAME;
	}
}
