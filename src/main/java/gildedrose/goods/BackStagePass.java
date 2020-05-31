package gildedrose.goods;

public class BackStagePass extends OurItem {

	public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
	private static final int BACKSTAGE_PASS_FIRST_QUALITY_INCREASER = 11;
	private static final int BACKSTAGE_PASS_SECOND_QUALITY_INCREASER = 6;

	public BackStagePass(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	public static int getBACKSTAGE_PASS_FIRST_QUALITY_INCREASER() {
		return BACKSTAGE_PASS_FIRST_QUALITY_INCREASER;
	}

	public static int getBACKSTAGE_PASS_SECOND_QUALITY_INCREASER() {
		return BACKSTAGE_PASS_SECOND_QUALITY_INCREASER;
	}

	@Override
	public void updateQuality() {
		if (super.sellIn < getBACKSTAGE_PASS_SECOND_QUALITY_INCREASER()) {
			increaseQuality();
			increaseQuality();
			increaseQuality();
			return;
		}
		if (super.sellIn < getBACKSTAGE_PASS_FIRST_QUALITY_INCREASER()) {
			increaseQuality();
			increaseQuality();
			return;
		}
		increaseQuality();
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			super.quality = 0;
		}
	}
}
