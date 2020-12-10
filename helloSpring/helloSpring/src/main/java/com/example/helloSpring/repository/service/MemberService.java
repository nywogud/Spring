package com.example.helloSpring.repository.service;

import com.example.helloSpring.domain.Member;
import com.example.helloSpring.repository.MemberRepository;
import com.example.helloSpring.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public static Long join(Member member){
        validationDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validationDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m->{throw new IllegalStateException("이미 존재하는 회원");});
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}