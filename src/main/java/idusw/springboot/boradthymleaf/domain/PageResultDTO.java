package idusw.springboot.boradthymleaf.domain;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtolist;

    private int totalPage; //총 페이지수
    private int curPage;// 현재 페이지
    private int size;

    private int start, end; //시작 페이지 번호, 끝 페이지 번호
    private boolean prev, next;

    private List<Integer> pageList;// 페이지 번호 목록

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){
        dtolist = result.stream().map(fn).collect(Collectors.toList()); // get record
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.curPage = pageable.getPageNumber() + 1 ;
        this.size = pageable.getPageSize();
        int tempEnd = (int)(Math.ceil(curPage / 3.0)) * 3;
        start = tempEnd - 3 + 1;
        prev = start > 1; // 1보다 크면 true 작으면 false
        next = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList()); // get pageNumber List
    }

}
