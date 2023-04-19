package idusw.springboot.boradthymleaf.controller;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.service.MemberService;
import idusw.springboot.boradthymleaf.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    MemberService memberService;
    public MemberController(MemoService memoService){
        this.memberService = memberService;
    }
    @GetMapping("/login")
    public String getLoginform(){
        return "/members/login";
    }
    @PostMapping("/login")
    public String postLoginform(){  //login 처리
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegisterform(Model model) {
        model.addAttribute("member",Member.builder().build());
        return "/members/register";
    }

    @PostMapping("/register")
    public String createMember(@ModelAttribute("member") Member member, Model medel) {
        System.out.println("this");
        member.setSeq(1l);
        if(memberService.create(member)>0)  //정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
        return "redirect:/";
        else
            return "/main/error";
    }

    @GetMapping("/update")
    public String getUpdateform() {
        return "/members/update";
    }

    @PutMapping("/update")
    public String updateMember() {
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String deleteMember() {
        return "redirect:/";
    }

    @GetMapping("/forgot")  //조회 read
    public String getForgotform() { // 분실 비밀번호 처리 요청 -> view
        return "/members/forgot-password"; //viw : template engine - thymeleaf .html
    }
    @PostMapping("/forgot")
    public String forgotMemberPassword() { //비밀번호(갱신)
        return "redirect:/";
    }
}
