package idusw.springboot.boradthymleaf.controller;

import idusw.springboot.boradthymleaf.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sb-admin-2")
public class HomeController {
    @Autowired
    MemoService memoService;  // MemoService 인터페이스의 구현체를 필드 주입

    @GetMapping("/")
    public String goHome() {
        return "/sb-admin-2/index";
    }
    @GetMapping("buttons")
    public String goButton() {
        return "/sb-admin-2/buttons";
    }
    @GetMapping("cards")
    public String goCard() {
        return "/sb-admin-2/cards";
    }

    @GetMapping("404")
    public String goerror() {
        return "/sb-admin-2/404";
    }
    @GetMapping("blank")
    public String goblank() {
        return "/sb-admin-2/blank";
    }

    @GetMapping("charts")
    public String gocharts() {
        return "/sb-admin-2/charts";
    }
    @GetMapping("forgot-password")
    public String gopassword() {
        return "/sb-admin-2/forgot-password";
    }
    @GetMapping("login")
    public String gologin() {
        return "/sb-admin-2/login";
    }
    @GetMapping("register")
    public String goregister() {
        return "/sb-admin-2/register";
    }
    @GetMapping("tables")
    public String gotables() {
        return "/sb-admin-2/tables";
    }

    @GetMapping("utilities-animation")
    public String goanimation() {
        return "/sb-admin-2/utilities-animation";
    }
    @GetMapping("utilities-border")
    public String goborder() {
        return "/sb-admin-2/utilities-border";
    }
    @GetMapping("utilities-color")
    public String gocolor() {
        return "/sb-admin-2/utilities-color";
    }
    @GetMapping("utilities-other")
    public String goother() {
        return "/sb-admin-2/utilities-other";
    }

}
