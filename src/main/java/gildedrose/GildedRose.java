package gildedrose;

import gildedrose.factory.ItemWrapperFactory;
import gildedrose.goods.*;

import java.util.*;
import java.util.stream.Collectors;

public class GildedRose {

	private final ItemWrapperFactory itemWrapperFactory = new ItemWrapperFactory();
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		newWay();
	}

	private void newWay() {
		var ourItems = convertToOurItems(items);
		for (ItemInterface item : ourItems) {
			item.atEndOfDay();
		}
		items = convertBackToItems(ourItems);
	}

	private List<ItemInterface> convertToOurItems(Item[] items) {
		return Arrays.stream(items)
					 .map(itemWrapperFactory::createFrom)
					 .collect(Collectors.toList());
	}

	private Item[] convertBackToItems(List<ItemInterface> ourItems) {
		return ourItems.stream()
					   .map(itemWrapperFactory::revert)
					   .toArray(Item[]::new);
	}
}

