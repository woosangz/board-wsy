package idusw.springboot.boradthymleaf.domain;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtolist;

    private int totalPage; //총 페이지수
    private int curPage;// 현재 페이지
    private int size;
    private int start, end; //시작 페이지 번호, 끝 페이지 번호
    private boolean prev, next;
    private  List<Integer> pageList;// 페이지 번호 목록

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){
        dtolist = result.stream().map(fn).collect(Collectors.toList());
    }


}
