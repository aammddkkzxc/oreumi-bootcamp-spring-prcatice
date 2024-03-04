package com.estsoft.hispring.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {  // 빈 주입
        this.memberService = memberService;
    }

    @GetMapping("/members")
    @ResponseBody
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }
}