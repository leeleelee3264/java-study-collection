package com.example.jpa.service;

import com.example.jpa.ErrorMessage;
import com.example.jpa.domain.Member;
import com.example.jpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By Seungmin lee
 * User: dnx
 * Date: 2021-02-09
 * Description:
 */
@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public Long join(Member member) {

        // 원래 예외처리 해야 하는데 예제어서 안 한 것임
        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    // 오 신기하다, class 안에서 쓸 메소드는 private 으로 선언을 하고 외부에 노출되는 애들은 public으로 하는 구나
    private void validateDuplicateMember(Member member) {

        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.EXIST_USER);
        }
    }

    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {

        return memberRepository.findOne(memberId);
    }
}
