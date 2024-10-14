package codingon.spring_boot_mybatis_practice.controller;

import codingon.spring_boot_mybatis_practice.domain.Board;
import codingon.spring_boot_mybatis_practice.dto.BoardDTO;
import codingon.spring_boot_mybatis_practice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 전체 조회
    @GetMapping
    public List<BoardDTO> listBoards() {
        return boardService.getAllBoard();
    }

    // 특정 Id 조회
    @GetMapping("/{id}")
    public BoardDTO getBoard(@PathVariable Integer id) {
        return boardService.getBoardById(id);
    }

    // 특정 Id 수정
    @PutMapping("/{id}")
    public BoardDTO updateBoard(@PathVariable Integer id, @RequestBody BoardDTO boardDTO) {
        boardDTO.setId(id);
        boardService.updateBoard(boardDTO);
        return boardDTO;
    }

    // 게시물 생성
    @PostMapping
    public BoardDTO createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.createBoard(boardDTO);
        return boardDTO;
    }

    // 게시물 삭제
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Integer id) {
        boardService.deleteBoard(id);
    }
}
