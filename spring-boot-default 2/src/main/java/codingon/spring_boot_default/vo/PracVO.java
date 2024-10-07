package codingon.spring_boot_default.vo;

import lombok.Getter;

import java.util.List;

@Getter
public class PracVO {
    private String name;
    private String gender;
    private String birth;
    private List<String> interest;
}
