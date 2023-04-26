package idusw.springboot.boradthymleaf.controller;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.domain.Memo;
import idusw.springboot.boradthymleaf.service.MemberService;
import idusw.springboot.boradthymleaf.service.MemoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {
    HttpSession session = null;
    MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/login")
    public String getLoginform(Model model){
        model.addAttribute("member",Member.builder().build()); //email, pw 를 전달을 위한 객체
        return "/members/login";
    }
    @PostMapping("/login")
    public String postLoginform(@ModelAttribute("member") Member member, HttpServletRequest request){  //login 처리
       Member result = null;
        if((result = memberService.login(member))!=null) {//정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
           session = request.getSession();
            session.setAttribute("mb", result);
            System.out.println("login");
            return "redirect:/";}
        else
            return "/main/error";
    }

    @GetMapping("/logout")
    public String logoutMember(){
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/register")
    public String getRegisterform(Model model) {
        model.addAttribute("member",Member.builder().build());
        return "/members/register";
    }

    @PostMapping("/register")
    public String createMember(@ModelAttribute("member") Member member, Model medel) {
        if(memberService.create(member)>0)  //정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
        return "redirect:/";
        else
            return "/main/error";
    }
    @GetMapping("/{seq}")
    public String getMember(@PathVariable("seq") Long seq, Model model ){
        Member result = new Member(); //반환
        Member m = new Member(); // 매개변수로 전달
        m.setSeq(seq);
        result = memberService.read(m);
        // MemberService 가 MemberRepository에게 전달
        // MemberRepository가 JPARepository 인터페이스의 구현체르 활용할 수 있음    interface 기능을 선언만 구현
        model.addAttribute("member", result);
        return "/members/detail";
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
