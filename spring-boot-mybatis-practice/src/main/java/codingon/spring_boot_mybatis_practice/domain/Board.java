package codingon.spring_boot_mybatis_practice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String registered;
}
