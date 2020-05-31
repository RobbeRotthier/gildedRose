package gildedrose.goods;

public interface ItemInterface {

	void atEndOfDay();

	void updateQuality();

	void whenSellDatePassed();

	String getName();

	int getSellIn();

	int getQuality();
}
