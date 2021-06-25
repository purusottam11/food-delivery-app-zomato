package com.purusottam.zomato.controller;

import com.purusottam.zomato.dto.ItemDto;
import com.purusottam.zomato.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/addItem")
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto){
        try {
            return new ResponseEntity<>(itemService.addItem(itemDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/updateItem/{itemId}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable String itemId,@RequestBody ItemDto itemDto){
        try {
            return new ResponseEntity<>(itemService.updateItem(itemId,itemDto),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getItem/{itemId}")
    public ResponseEntity<ItemDto> getItem(@PathVariable String itemId){
        try {
            return new ResponseEntity<>(itemService.getItem(itemId),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable String itemId){
        try {
            return new ResponseEntity<>(itemService.deleteItem(itemId),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getItemsByRestaurantId/{restaurantId}")
    public ResponseEntity<List<ItemDto>> getItemsByRestaurantId(@PathVariable String restaurantId){
        try {
            return new ResponseEntity<>(itemService.getItemsByRestaurantId(restaurantId),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
