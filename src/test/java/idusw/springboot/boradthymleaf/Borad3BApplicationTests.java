package idusw.springboot.boradthymleaf;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.domain.Memo;
import idusw.springboot.boradthymleaf.repository.MemberRepository;
import idusw.springboot.boradthymleaf.service.MemberService;
import idusw.springboot.boradthymleaf.service.MemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Borad3BApplicationTests {
    @Autowired
    MemberService memberService;
    @Autowired
    MemoService memoService;

    @Test
    void createMember() {
        Member member = Member.builder().
                email("12@12.com")
                .name("12")
                .pw("12").
                build();
        if(memberService.create(member)>0)  //정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            System.out.println("등록 성공");
        else
            System.out.println("등록 실패");
    }
    @Test
    void readMember(){
        Member member = Member.builder()
                .seq(52L)
                .build();
        Member result = null;
        if((result = memberService.read(member)) != null)  //정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            System.out.println("조회 성공"+ result.getEmail() + ":" + result.getName());
        else
            System.out.println("조회 실패");
    }

    @Test
    public void readMemo(){
        Memo m = new Memo();
        m.setMno(1L);
        Memo result;
        if((result =memoService.read(m)) != null)
            System.out.println();
    }


}
