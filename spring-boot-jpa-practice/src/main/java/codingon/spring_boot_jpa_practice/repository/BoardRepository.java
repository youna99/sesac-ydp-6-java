package codingon.spring_boot_jpa_practice.repository;

import codingon.spring_boot_jpa_practice.entity.Board;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
