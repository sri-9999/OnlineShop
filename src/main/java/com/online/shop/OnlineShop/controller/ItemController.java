package com.online.shop.OnlineShop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shop.OnlineShop.model.Item;
import com.online.shop.OnlineShop.service.ItemService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4400", "http://localhost:4200"})
@RestController
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("/api/items")
	public List<Item> getItems() {
		return itemService.getAllItems();
	}
}
