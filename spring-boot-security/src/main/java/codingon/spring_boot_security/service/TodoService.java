package codingon.spring_boot_security.service;

import codingon.spring_boot_security.dto.TodoDTO;
import codingon.spring_boot_security.entity.TodoEntity;
import codingon.spring_boot_security.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
// Simple logging facade for java
// - 로그 라이브러리
// - 용도에 따라서 info, debug, warn, error 나눠서 로깅
// - 로깅하고 싶은 클래스에 해당 어노테이션을 작성하면 됨
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    // create todo
    public List<TodoEntity> create(final TodoEntity entity) {
        validate(entity); // 유효성 검사

        repository.save(entity); // db insert 수행

        log.info("Entity Id: {} is saved", entity.getId()); // 로그 찍기

        // db select 수행 (추가한 그 행을 바로 다시 보여주기)
        return repository.findByUserId(entity.getUserId());
    }

    // read todo
    public List<TodoEntity> retrieve(final String userId) {
        return repository.findByUserId(userId);
    }

    // update todo
    public TodoEntity update(final TodoEntity entity) {
        validate(entity); // 유효성 검사

        final TodoEntity original = repository.findById(entity.getId())
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        original.setTitle(entity.getTitle());
        original.setDone(entity.isDone());

        log.info("Entity Id: {} is updated", entity.getId());

        return repository.save(original);
    }

    // delete todo
    public TodoDTO delete(final Long id, final String userId) {
        final TodoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (!entity.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized access");
        }

        TodoDTO deletedTodo = new TodoDTO(entity);

        repository.delete(entity);

        log.info("Entity Id: {} is deleted", entity.getId());

        return deletedTodo;
    }

    // 유효성 검사
    private void validate(final TodoEntity entity) {
        if (entity == null) {
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }

        if (entity.getUserId() == null) {
            log.warn("Unknown user");
            throw new RuntimeException("Unknown user");
        }
    }

}