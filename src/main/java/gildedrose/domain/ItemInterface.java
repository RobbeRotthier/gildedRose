package gildedrose.domain;

public interface ItemInterface {

	void atEndOfDay();

	String getName();

	int getSellIn();

	int getQuality();

	Item getItem();
}
