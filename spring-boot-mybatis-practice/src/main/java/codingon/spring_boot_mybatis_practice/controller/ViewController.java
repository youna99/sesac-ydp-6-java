package codingon.spring_boot_mybatis_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String redirectToBoards() { return "redirect:/boards"; }

    @GetMapping("/boards")
    public String listBoards() {return "boardList";}

    @GetMapping("/boards/new")
    public String newBoardForm() {
        return "boardForm";
    }

    @GetMapping("/boards/{id}/edit")
    public String editBoardForm() {
        return "boardForm";
    }
}