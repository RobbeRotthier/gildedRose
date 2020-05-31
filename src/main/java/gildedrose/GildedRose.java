package gildedrose;

import gildedrose.factory.OurItemFactory;
import gildedrose.goods.*;

import java.util.*;
import java.util.stream.Collectors;

public class GildedRose {

	private final OurItemFactory ourItemFactory = new OurItemFactory();
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		newWay();
	}

	private void newWay() {
		var ourItems = convertToOurItems(items);
		for (DayPasses item : ourItems) {
			item.updateQuality();
			item.atEndOfDay();
			item.whenSellDatePassed();
		}
		items = convertBackToItems(ourItems);
	}

	private List<OurItem> convertToOurItems(Item[] items) {
		return Arrays.stream(items)
					 .map(ourItemFactory::createFrom)
					 .collect(Collectors.toList());
	}

	private Item[] convertBackToItems(List<OurItem> ourItems) {
		return ourItems.stream()
					   .map(ourItemFactory::revert)
					   .toArray(Item[]::new);
	}
}

