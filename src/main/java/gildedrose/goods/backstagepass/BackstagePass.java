package gildedrose.goods.backstagepass;

import gildedrose.config.Config;
import gildedrose.goods.OurItem;

public class BackstagePass extends OurItem {

	public BackstagePass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public static int getBackStagePassFirstQualityIncreaser() {
		return Config.BACKSTAGE_PASS_FIRST_QUALITY_INCREASER;
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			super.quality = 0;
		}
	}

	public static int getBackStagePassSecondQualityIncreaser() {
		return Config.BACKSTAGE_PASS_SECOND_QUALITY_INCREASER;
	}

	@Override
	public void updateQuality() {
		if (super.sellIn < getBackStagePassSecondQualityIncreaser()) {
			increaseQuality();
			increaseQuality();
			increaseQuality();
			return;
		}
		if (super.sellIn < getBackStagePassFirstQualityIncreaser()) {
			increaseQuality();
			increaseQuality();
			return;
		}
		increaseQuality();
	}
}
