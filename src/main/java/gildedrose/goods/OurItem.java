package gildedrose.goods;

import gildedrose.util.QualityUpdater;

public class OurItem extends Item implements ItemInterface {

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

	@Override
	public String getName() {
		return super.name;
	}

	@Override
	public int getSellIn() {
		return super.sellIn;
	}

	@Override
	public int getQuality() {
		return super.quality;
	}

	public void increaseQuality() {
		qualityUpdater.increaseQuality(this);
	}

	public void decreaseQuality() {
		qualityUpdater.decreaseQuality(this);
	}

	public boolean sellingDatePassed() {
		return getSellIn() < 0;
	}
}

