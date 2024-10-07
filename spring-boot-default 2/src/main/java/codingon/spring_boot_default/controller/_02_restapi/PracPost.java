package codingon.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PracPost {
    @GetMapping("/postprac")
    public String getReq() {
        return "_02_restapi/pracPostReq";
    }

    @PostMapping("/post/prac")
    public String postRes1(@RequestParam String name,
                           @RequestParam String gender,
                           @RequestParam String birth,
                           @RequestParam String interest, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("birth", birth);
        model.addAttribute("interest", interest);
        return "_02_restapi/pracPostRes";
    }

}
