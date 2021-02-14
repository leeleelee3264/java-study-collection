package com.example.jpa.controller;

import com.example.jpa.domain.Member;
import com.example.jpa.domain.Order;
import com.example.jpa.domain.OrderSearch;
import com.example.jpa.domain.item.Item;
import com.example.jpa.service.ItemService;
import com.example.jpa.service.MemberService;
import com.example.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-10
 * Description:
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/order")
    public String createForm(
            Model model
    ) {

        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(
        @RequestParam("memberId") Long memberId,
        @RequestParam("itemId") Long itemId,
        @RequestParam("count") int count
    ) {

        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(
            @ModelAttribute("orderSearch")OrderSearch orderSearch,
            Model model
    ) {

        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);

        return "order/orderList";
    }


}
