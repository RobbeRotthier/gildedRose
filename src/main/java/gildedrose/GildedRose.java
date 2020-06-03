package gildedrose;

import gildedrose.domain.*;
import gildedrose.domain.factory.ItemWrapperFactory;

import java.util.*;
import java.util.stream.Collectors;

public class GildedRose {

	private final ItemWrapperFactory itemWrapperFactory = new ItemWrapperFactory();
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		var itemWrappers = convertToOurItems(items);
		for (ItemInterface item : itemWrappers) {
			item.atEndOfDay();
		}
		items = convertBackToItems(itemWrappers);
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

