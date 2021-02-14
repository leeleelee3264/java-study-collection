package com.example.jpa.repository;

import com.example.jpa.domain.item.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-10
 * Description:
 */
@Repository
public class ItemRepository implements MyRepository<Item>{

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Item item) {
        if(item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    @Override
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> findAll() {

        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
