package idusw.springboot.boradthymleaf.controller;

import idusw.springboot.boradthymleaf.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    MemoService memoService;  // MemoService 인터페이스의 구현체를 필드 주입

    @GetMapping
    public String goHome() {
        return "/main/index";
    }
    @GetMapping("buttons")
    public String goButton() {
        return "/main/buttons";
    }
    @GetMapping("cards")
    public String goCard() {
        return "/main/cards";
    }

    @GetMapping("404")
    public String goerror() {
        return "/main/404";
    }
    @GetMapping("blank")
    public String goblank() {
        return "/main/blank";
    }

    @GetMapping("charts")
    public String gocharts() {
        return "/main/charts";
    }

    @GetMapping("tables")
    public String gotables() {
        return "/main/tables";
    }

    @GetMapping("utilities-animation")
    public String goanimation() {
        return "/main/utilities-animation";
    }
    @GetMapping("utilities-border")
    public String goborder() {
        return "/main/utilities-border";
    }
    @GetMapping("utilities-color")
    public String gocolor() {
        return "/main/utilities-color";
    }
    @GetMapping("utilities-other")
    public String goother() {
        return "/main/utilities-other";
    }

}
