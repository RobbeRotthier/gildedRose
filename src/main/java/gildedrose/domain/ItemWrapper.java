package gildedrose.domain;

import gildedrose.domain.util.QualityUpdater;

public abstract class ItemWrapper implements ItemInterface {

	private final Item item;

	public ItemWrapper(Item item) {
		this.item = item;
	}

	@Override
	public void atEndOfDay() {
		updateQuality();
		updateSellIn();
		whenSellDatePassed();
	}

	protected void updateSellIn() {
		decreaseSellIn();
	}

	protected void updateQuality() {
		decreaseQuality(1);
	}

	protected void whenSellDatePassed() {
		if (sellingDatePassed()) {
			decreaseQuality(1);
		}
	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public String getName() {
		return item.name;
	}

	@Override
	public int getSellIn() {
		return item.sellIn;
	}

	public int getQuality() {
		return item.quality;
	}

	public void setQuality(int quality) {
		item.quality = quality;
	}

	private void decreaseSellIn() {
		item.sellIn--;
	}

	public void increaseQuality(int amount) {
		QualityUpdater.increase(this, amount);
	}

	public void decreaseQuality(int amount) {
		QualityUpdater.decrease(this, amount);
	}

	public boolean sellingDatePassed() {
		return getSellIn() < 0;
	}
}

