package com.example.jpa.service;

import com.example.jpa.domain.*;
import com.example.jpa.domain.item.Item;
import com.example.jpa.repository.MemberRepository;
import com.example.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-10
 * Description:
 */
@Service
@Transactional
public class OrderService {

    @Autowired private MemberRepository memberRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private ItemService itemService;

    public Long order(Long memberId, Long itemId, int count) {

        // 확인 -> id를 넘기는게 아니라 entity 자체를 넘긴다
        Member member = memberRepository.findOne(memberId);
        Item item = itemService.findOne(itemId);


        Delivery delivery = new Delivery(member.getAddress());
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch) {

        return orderRepository.findAll(orderSearch);
    }


}
