package com.example.jpa.domain.item;

import com.example.jpa.ErrorMessage;
import com.example.jpa.domain.Category;
import com.example.jpa.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-09
 * Description: 아... 추상 클래스는 아예 생성자를 만들어 두지도 않네
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


    // business logic
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }


    public void removeStock(int quantity) {

        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) {
            throw new NotEnoughStockException(ErrorMessage.OUT_OF_STOCK);
        }

        this.stockQuantity = restStock;
    }


}
