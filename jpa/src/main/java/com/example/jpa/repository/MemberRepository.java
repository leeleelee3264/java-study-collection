package com.example.jpa.repository;

import com.example.jpa.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.List;
/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-09
 * Description:
 */

@Repository
public class MemberRepository implements MyRepository<Member>{

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Member member) {

        em.persist(member);
    }

    @Override
    public Member findOne(Long id) {

        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {

        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                // 지금 여기에 setParam 안해서 엄청 삽질
                .setParameter("name", name)
                .getResultList();
    }

}
