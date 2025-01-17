package home.pallagi.jozsef.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import home.pallagi.jozsef.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @EntityGraph(attributePaths = {"labels"})
    List<Todo> findByUserIdAndTitleContainingOrDescriptionContaining(Long userId, String title, String description);

    @Query("SELECT t FROM Todo t JOIN t.labels l WHERE l.id = :labelId AND t.user.id = :userId")
    List<Todo> todosByLabelAndUserId(Long labelId, Long userId);

    @EntityGraph(attributePaths = {"labels"})
    List<Todo> findByUserId(Long userId);

    Optional<Todo> findByUserIdAndId(Long userId, Long id);
}
