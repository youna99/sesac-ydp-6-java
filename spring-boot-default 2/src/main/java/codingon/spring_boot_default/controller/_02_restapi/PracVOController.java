package codingon.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import codingon.spring_boot_default.vo.PracVO;

@Controller
public class PracVOController {

    @GetMapping("/prac/axios")
    public String getReq() {
        return "_02_restapi/pracVO";
    }

    @PostMapping("/prac/axios/vo")
    @ResponseBody
    public String pracVO(@RequestBody PracVO pracVO) {
        System.out.println("name: " + pracVO.getName());
        System.out.println("gender: " + pracVO.getGender());
        System.out.println("birth: " + pracVO.getBirth());
        System.out.println("interest: " + pracVO.getInterest());
        System.out.println(pracVO.getName() + "회원가입 성공");
        return pracVO.getName();
    }
}
