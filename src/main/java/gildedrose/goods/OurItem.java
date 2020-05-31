package gildedrose.goods;

import gildedrose.util.QualityUpdater;

public class OurItem extends Item implements DayPasses {

	private final QualityUpdater qualityUpdater = new QualityUpdater();

	public OurItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void atEndOfDay() {
		super.sellIn--;
	}

	@Override
	public void updateQuality() {
		decreaseQuality();
	}

	@Override
	public void whenSellDatePassed() {
		if (sellingDatePassed()) {
			decreaseQuality();
		}
	}

	void increaseQuality() {
		qualityUpdater.increaseQuality(this);
	}

	void decreaseQuality() {
		qualityUpdater.decreaseQuality(this);
	}

	boolean sellingDatePassed() {
		return super.sellIn < 0;
	}
}

