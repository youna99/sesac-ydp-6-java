package codingon.spring_boot_jpa_practice.service;

import codingon.spring_boot_jpa_practice.dto.BoardDTO;
import codingon.spring_boot_jpa_practice.entity.Board;
import codingon.spring_boot_jpa_practice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (Board board:boards) {
            BoardDTO boardDTO = convertToDTO(board);
            boardDTOS.add(boardDTO);
        }

        return boardDTOS;
    }

    // entity(domain) to dto
    private BoardDTO convertToDTO(Board board) {
        return BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();
    }
}
