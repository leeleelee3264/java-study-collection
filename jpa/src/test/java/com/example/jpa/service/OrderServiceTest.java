package com.example.jpa.service;

import com.example.jpa.domain.Address;
import com.example.jpa.domain.Member;
import com.example.jpa.domain.Order;
import com.example.jpa.domain.OrderStatus;
import com.example.jpa.domain.item.Book;
import com.example.jpa.domain.item.Item;
import com.example.jpa.exception.NotEnoughStockException;
import com.example.jpa.repository.OrderRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-10
 * Description:
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    private Member createMember() {

        Member member = new Member();
        member.setName("jamie");
        member.setAddress(new Address("Canada", "Calgary", "123"));

        em.persist(member);
        return member;
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);

        em.persist(book);
        return book;
    }
    @Test
    public void order() throws Exception {

        // given
        Member member = createMember();
        Item item = createBook("jpa", 10000, 10);
        int orderCount = 2;

        // when
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus());
        assertEquals(1, getOrder.getOrderItems().size());
        assertEquals( 10000 * 2, getOrder.getTotalPrice());
        assertEquals(8, item.getStockQuantity());
    }


    @Test
    public void order_exception() {

        Assertions.assertThrows(NotEnoughStockException.class, () -> {
            // given
            Member member = createMember();
            Item item = createBook("jpa", 10000, 10);

            int orderCount = 11;

            orderService.order(member.getId(), item.getId(), orderCount);
        });
    }

    @Test
    public void order_cancel() {

        // given
        Member member = createMember();
        Item item = createBook("jpa", 10000, 10);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // when
        orderService.cancelOrder(orderId);

        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, getOrder.getStatus());
        assertEquals( 10, item.getStockQuantity());
    }
}