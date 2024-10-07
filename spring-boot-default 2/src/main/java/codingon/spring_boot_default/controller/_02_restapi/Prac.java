package codingon.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Prac {
    @GetMapping("/introduce/{name}")
    public String getIntroduce(@PathVariable String name, Model model) {

        model.addAttribute("name", name);

        return "_02_restapi/prac";
    }

    @GetMapping("introduce2")
    public String getIntroduce2(@RequestParam(value = "name") String name,
                                @RequestParam(value = "age") int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "_02_restapi/prac_age";
    }
}
