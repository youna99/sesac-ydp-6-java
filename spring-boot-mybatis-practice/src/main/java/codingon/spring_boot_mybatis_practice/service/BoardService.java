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

    // 모든 게시물 조회
    public List<BoardDTO> getAllBoard() {
        List<Board> boards = boardMapper.findAll();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (Board board : boards) {
            BoardDTO boardDTO = convertToDto(board);
            boardDTOS.add(boardDTO);
        }
        return boardDTOS;
    }

    // 특정 ID 조회
    public BoardDTO getBoardById(Integer id) {
        Board board = boardMapper.findById(id);
        return convertToDto(board);
    }

    // 특정 ID 수정
    public void updateBoard(BoardDTO boardDTO) {
        Board board = convertToEntity(boardDTO);
        boardMapper.update(board);
    }

    // 게시물 생성
    public void createBoard(BoardDTO boardDTO) {
        Board board = convertToEntity(boardDTO);
        boardMapper.insert(board);
    }

    // 게시물 삭제
    public void deleteBoard(Integer id) {
        boardMapper.delete(id);
    }

    // dto to domain
    private Board convertToEntity(BoardDTO dto) {
        Board board = new Board();
        board.setId(dto.getId());
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setWriter(dto.getWriter());

        return board;
    }

    // domain to dto
    private BoardDTO convertToDto(Board board) {
        BoardDTO dto = new BoardDTO();
        dto.setId(board.getId());
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        dto.setWriter(board.getWriter());

        return dto;
    }
}
