package gildedrose.goods;

public class AgedBrie extends OurItem {

	private static final String NAME = "Aged Brie";

	public AgedBrie(int sellIn, int quality) {
		super(getName(), sellIn, quality);
	}

	public static String getName() {
		return NAME;
	}
}
