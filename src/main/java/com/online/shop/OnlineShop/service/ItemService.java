package com.online.shop.OnlineShop.service;

import org.springframework.stereotype.Service;

import com.online.shop.OnlineShop.model.Item;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
	private final List<Item> items = new ArrayList<>();

	@PostConstruct
    public void init() {
        items.add(new Item(101, "Ballpoint Pen", "Smooth writing blue ink pen"));
        items.add(new Item(223, "Notebook", "A5 size ruled notebook with 200 pages"));
        items.add(new Item(342, "Stapler", "Medium size stapler for office use"));
        items.add(new Item(435, "Highlighter", "Yellow fluorescent highlighter"));
        items.add(new Item(54, "Eraser", "Soft white eraser for clean erasing"));
        items.add(new Item(634, "Running Shoes", "Men's lightweight running shoes"));
        items.add(new Item(74, "Sneakers", "Casual white sneakers for women"));
        items.add(new Item(834, "Formal Shoes", "Black leather formal shoes"));
        items.add(new Item(9, "Sandals", "Comfortable summer sandals"));
        items.add(new Item(1013, "Sports Shoes", "All-purpose sports shoes for kids"));
    }

	public List<Item> getAllItems() {
		return items;
	}
}
