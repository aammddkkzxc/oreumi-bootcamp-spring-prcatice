package com.estsoft.hispring.controller;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {   // 빈 주입
        this.memberRepository = memberRepository;
    }

    public List<MemberDTO> getAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        System.out.println("memberList = " + memberList);
        List<MemberDTO> resultList = memberList.stream().map(member -> new MemberDTO(member.getId(), member.getName())).toList();
        return resultList;   // 멤버 목록 얻기
    }
}
