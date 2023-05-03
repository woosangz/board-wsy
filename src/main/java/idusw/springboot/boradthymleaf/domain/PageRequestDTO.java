package idusw.springboot.boradthymleaf.domain;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequestDTO {
    private int page; //요청하는 펭지
    private int size; //페이지당 게시물 수

    public PageRequestDTO(){
        this.page = 1;
        this.size = 5;
    }
    public Pageable getPageable(Sort sort){
        return PageRequest.of(page -1, size, sort);
    }
}
