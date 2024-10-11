package codingon.spring_boot_mybatis_practice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
}
