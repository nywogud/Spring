package com.example.helloSpring.repository.service;

import com.example.helloSpring.domain.Member;
import com.example.helloSpring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach(){
        MemberService memberService;
        MemoryMemberRepository
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("Hello");
        //when
        Long saveId = MemberService.join(member);
        //then
        Member findMember = memoryMemberRepository.findById(saveId).get();
        System.out.println("findMember.getName() = " + findMember.getName() );
        System.out.println(member.getName());
//        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}