package codingon.spring_boot_mybatis_practice.service;

import codingon.spring_boot_mybatis_practice.domain.Board;
import codingon.spring_boot_mybatis_practice.dto.BoardDTO;
import codingon.spring_boot_mybatis_practice.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // '동그라미' 작성자의 정보를 반환
    public List<BoardDTO> getAllBoardA() {
        List<Board> boards = boardMapper.findAllA();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (Board board : boards) {
            BoardDTO boardDTO = convertToDto(board);
            boardDTOS.add(boardDTO);
        }
        return boardDTOS;
    }

    private BoardDTO convertToDto(Board board) {
        BoardDTO dto = new BoardDTO();
        dto.setId(board.getId());
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        dto.setWriter(board.getWriter());

        return dto;
    }
}
