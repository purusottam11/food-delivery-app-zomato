package com.purusottam.zomato.service;

import com.purusottam.zomato.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto addItem(ItemDto itemDto);
    ItemDto updateItem(String itemId,ItemDto itemDto);
    ItemDto getItem(String itemId);
    ItemDto deleteItem(String itemId);
    List<ItemDto> getItemsByRestaurantId(String restaurantId);
    List<ItemDto> getActiveItems(); // Items are not out of stock
    List<ItemDto> getActiveItemsByPageNumber(String restaurantId,Integer pageNumber,Integer pageSize);
}
