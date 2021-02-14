package com.example.jpa.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-10
 * Description:
 */
@Getter
@Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
