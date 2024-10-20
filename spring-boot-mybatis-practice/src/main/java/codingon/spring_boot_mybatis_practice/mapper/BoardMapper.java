package codingon.spring_boot_mybatis_practice.mapper;

import codingon.spring_boot_mybatis_practice.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // xml 기반 매퍼
    List<Board> findAll();
    Board findById(Integer id);
    void insert(Board board);
    void update(Board board);
    void delete(Integer id);
}
