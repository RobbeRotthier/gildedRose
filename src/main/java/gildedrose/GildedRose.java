package gildedrose;

import gildedrose.goods.*;
import gildedrose.util.QualityUpdater;

public class GildedRose {

	private final QualityUpdater qualityUpdater = new QualityUpdater();
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateQualityBeforeSellInDays(item);
			endOfDaySellIn(item);
			updateQualityAfterSellInDays(item);
		}
	}

	private void updateQualityAfterSellInDays(Item item) {
		if (item.sellIn < 0) {
			if (!isOfType(item, AgedBrie.getName())) {
				if (!isOfType(item, BackStagePass.getName())) {
					if (!isOfType(item, SulfurasHand.getName())) {
						decreaseQuality(item);
					}
				} else {
					item.quality = 0;
				}
			} else {
				increaseQuality(item);
			}
		}
	}

	private void endOfDaySellIn(Item item) {
		if (!isOfType(item, SulfurasHand.getName())) {
			decreaseSellIn(item);
		}
	}

	private void updateQualityBeforeSellInDays(Item item) {
		if (!isOfType(item, AgedBrie.getName()) && !isOfType(item, BackStagePass.getName())) {
			if (!isOfType(item, SulfurasHand.getName())) {
				decreaseQuality(item);
			}
		} else {
			increaseQuality(item);

			if (isOfType(item, BackStagePass.getName())) {
				if (item.sellIn < BackStagePass.getBACKSTAGE_PASS_FIRST_QUALITY_INCREASER()) {
					increaseQuality(item);
				}

				if (item.sellIn < BackStagePass.getBACKSTAGE_PASS_SECOND_QUALITY_INCREASER()) {
					increaseQuality(item);
				}
			}
		}
	}

	private void increaseQuality(Item item) {
		qualityUpdater.increaseQuality(item);
	}

	private void decreaseQuality(Item item) {
		qualityUpdater.decreaseQuality(item);
	}

	private boolean isOfType(Item item, String backstage_pass) {
		return item.name.equals(backstage_pass);
	}

	private void decreaseSellIn(Item item) {
		item.sellIn--;
	}
}

