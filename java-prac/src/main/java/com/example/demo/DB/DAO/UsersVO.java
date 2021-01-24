package com.example.demo.DB.DAO;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-24
 * description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="users")
public class UsersVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int salary;

    @Builder
    public UsersVO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
