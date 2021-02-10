package com.example.jpa.domain;

import com.example.jpa.ErrorMessage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-09
 * Description:
 */
@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // 생성 메소드 약간 빌더 패턴인거 같은데
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {

        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);

        for(OrderItem orderItem: orderItems) {
            order.addOrderItem(orderItem);
        }

        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDate.now());

        return order;
    }

    // business logic
    public void cancel() {

        if(delivery.getStatus() == DeliveryStatus.COMP) {
            throw new RuntimeException(ErrorMessage.ALREADY_DELIVERED);
        }

        this.setStatus(OrderStatus.CANCEL);
        for(OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }


    //

    private void addOrderItem(OrderItem orderItem) {
        // 자기도 추가하고 주인도 추가 하는 형식인가봄
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }


    public int getTotalPrice() {
        int totalPrice = 0;

        for(OrderItem orderItem: orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }

        return totalPrice;
    }


}
