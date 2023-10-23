package com.example.myDemo.controller;


import com.example.myDemo.entity.Member;
import com.example.myDemo.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService theMemberService) {
        memberService = theMemberService;
    }

    @GetMapping("/listMember")
    public String listMembers(Model theModel) {
        List<Member> theMembers = memberService.findAll();

        theModel.addAttribute("members", theMembers);

        return "members/list-member";
    }

    @GetMapping("addMember")
    public String addMember(Model theModel) {
        Member theMember = new Member();
        theModel.addAttribute("member", theMember);
        return "members/addMember";
    }

    @PostMapping("saveMember")
    public String saveMember(@ModelAttribute("member") Member theMember) {

        memberService.save(theMember);

        return "redirect:/members/listMember";
    }

    @PostMapping("showOneDisplay")
    public String showOneDisplay(@RequestParam("memberId") int theId, Model theModel) {

        Member theMember = memberService.findById(theId);

        theModel.addAttribute("member", theMember);

        return "members/showOneMember";
    }

    @GetMapping("pageMembers")
    public String listMembers(Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10); // 每页显示10条记录
        Page<Member> memberPage = memberService.getAllMembers(pageable);

        model.addAttribute("members", memberPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", memberPage.getTotalPages());

        return "members/pageMembers";
    }
}
