package gildedrose.goods.backstagepass;

import gildedrose.config.Config;
import gildedrose.goods.*;

public abstract class BackstagePass extends ItemWrapper {

	public BackstagePass(Item item) {
		super(item);
	}

	public static int getBackStagePassFirstQualityIncreaser() {
		return Config.BACKSTAGE_PASS_FIRST_QUALITY_INCREASER;
	}

	public static int getBackStagePassSecondQualityIncreaser() {
		return Config.BACKSTAGE_PASS_SECOND_QUALITY_INCREASER;
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			super.setQuality(Config.MIN_QUALITY);
		}
	}

	@Override
	public void updateQuality() {
		if (super.getSellIn() < getBackStagePassSecondQualityIncreaser()) {
			increaseQuality(3);
			return;
		}
		if (super.getSellIn() < getBackStagePassFirstQualityIncreaser()) {
			increaseQuality(2);
			return;
		}
		increaseQuality(1);
	}
}
