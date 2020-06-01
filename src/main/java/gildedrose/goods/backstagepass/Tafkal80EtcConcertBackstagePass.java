package gildedrose.goods.backstagepass;

import gildedrose.goods.Item;

public class Tafkal80EtcConcertBackstagePass extends BackstagePass {

	public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

	public Tafkal80EtcConcertBackstagePass(int sellIn, int quality) {
		super(NAME, sellIn, quality);
	}

	public Tafkal80EtcConcertBackstagePass(Item item) {
		super(item);
	}
}
