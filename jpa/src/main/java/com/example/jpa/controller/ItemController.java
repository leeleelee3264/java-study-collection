package com.example.jpa.controller;

import com.example.jpa.domain.item.Book;
import com.example.jpa.domain.item.Item;
import com.example.jpa.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-10
 * Description:
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(){
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(Book item) {

        itemService.saveItem(item);
        return "redirect:/items";
    }


    @GetMapping("/items")
    public String list(Model model) {

        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);

        return "items/itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String updateItemFrom(
            @PathVariable("itemId") Long itemId,
            Model model
    ) {
        Item item = itemService.findOne(itemId);
        model.addAttribute("item", item);

        return "items/updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(
            @PathVariable("itemId") Long id,
            @ModelAttribute("item") Book item
    ) {

        itemService.saveItem(item);
        return "redirect:/items";
    }

}
