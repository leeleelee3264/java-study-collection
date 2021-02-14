package com.example.jpa.service;

import com.example.jpa.domain.Member;
import com.example.jpa.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-09
 * Description:
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void join() throws Exception {

        // given
        Member member = new Member();
        member.setName("jamie");

        // when
        Long saveId = memberService.join(member);

        // then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void join_dupli() {

        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            // given
            Member member = new Member();
            member.setName("jamie");

            Member member2 = new Member();
            member2.setName("jamie");

            // when
            memberService.join(member);
            memberService.join(member2);
        });

    }
}