package gildedrose.goods;

public class BackStagePass extends OurItem {

	private static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
	private static final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASER = 11;
	private static final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASER = 6;

	public BackStagePass(int sellIn, int quality) {
		super(getName(), sellIn, quality);
	}

	public static String getName() {
		return NAME;
	}

	public static int getBACKSTAGE_PASS_FIRST_QUALITY_INCREASER() {
		return BACKSTAGE_PASS_FIRST_QUALITY_INCREASER;
	}

	public static int getBACKSTAGE_PASS_SECOND_QUALITY_INCREASER() {
		return BACKSTAGE_PASS_SECOND_QUALITY_INCREASER;
	}
}
