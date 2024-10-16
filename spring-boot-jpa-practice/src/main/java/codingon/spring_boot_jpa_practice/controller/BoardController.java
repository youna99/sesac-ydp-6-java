package codingon.spring_boot_jpa_practice.controller;

import codingon.spring_boot_jpa_practice.dto.BoardDTO;
import codingon.spring_boot_jpa_practice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<BoardDTO> listBoards() {
        return boardService.getAllBoards();
    }
}
