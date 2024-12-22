package home.pallagi.jozsef.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import home.pallagi.jozsef.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUserIdAndTitleContainingOrDescriptionContaining(Long userId, String title, String description);

    @Query("SELECT t FROM Todo t JOIN t.labels l WHERE l.id = :labelId")
    List<Todo> todosByLabel(Long labelId);

    List<Todo> findByUserId(Long userId);

}
