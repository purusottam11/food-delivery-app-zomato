package com.purusottam.zomato.impl;

import com.purusottam.zomato.dto.ItemDto;
import com.purusottam.zomato.model.Item;
import com.purusottam.zomato.repository.ItemRepository;
import com.purusottam.zomato.repository.RestaurantRepository;
import com.purusottam.zomato.service.ItemService;
import com.purusottam.zomato.utils.CopyUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
public class ItemImpl implements ItemService {

    private final RestaurantRepository restaurantRepository;
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public ItemDto addItem(ItemDto itemDto) {
        if(!restaurantRepository.existsById(itemDto.getRestaurantId())){
            throw new RuntimeException("Restaurant not found ... 404");
        }
        itemRepository.findByRestaurantIdAndItemName(itemDto.getRestaurantId(),itemDto.getItemName()).ifPresent(
                i->{
                    throw new RuntimeException("Item is already exist ... !");
                }
        );
        Item item = new Item();
        CopyUtils.copySafe(itemDto,item);
        item = itemRepository.save(item);
        CopyUtils.copySafe(item,itemDto);
        return itemDto;
    }

    @Override
    @Transactional
    public ItemDto updateItem(String itemId, ItemDto itemDto) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new RuntimeException("Item not found ... 404 "));
        itemRepository.findByRestaurantIdAndItemName(itemDto.getRestaurantId(),itemDto.getItemName()).ifPresent(
                i->{
                    throw new RuntimeException("Item is already exist ... !");
                }
        );
        if (itemDto.getRestaurantId() != null && !restaurantRepository.existsById(itemDto.getRestaurantId())){
            throw new RuntimeException("Restaurant not found ... 404");
        }
        CopyUtils.copySafe(itemDto,item);
        item = itemRepository.save(item);
        CopyUtils.copySafe(item,itemDto);
        return itemDto;
    }

    @Override
    public ItemDto getItem(String itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new RuntimeException("Item not found ... 404"));
        ItemDto itemDto = new ItemDto();
        CopyUtils.copySafe(item,itemDto);
        return itemDto;
    }

    @Override
    @Transactional
    public ItemDto deleteItem(String itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new RuntimeException("Item not found ... 404"));
        ItemDto itemDto = new ItemDto();
        CopyUtils.copySafe(item,itemDto);
        itemRepository.delete(item);
        return itemDto;
    }

    @Override
    public List<ItemDto> getItemsByRestaurantId(String restaurantId) {
        List<Item> items = itemRepository.findByRestaurantId(restaurantId).orElseThrow(
                () -> new RuntimeException("Item not found ... 404"));
        List<ItemDto> list =  CopyUtils.copySafe(items,ItemDto.class);
        return list;
    }

    @Override
    public List<ItemDto> getActiveItems() {
        return null;
    }

    @Override
    public List<ItemDto> getActiveItemsByPageNumber(String restaurantId, Integer pageNumber, Integer pageSize) {
        return null;
    }
}
