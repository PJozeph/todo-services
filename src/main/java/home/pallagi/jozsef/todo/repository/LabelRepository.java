package home.pallagi.jozsef.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import home.pallagi.jozsef.todo.entity.Label;

import java.util.Set;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    @Query("SELECT l FROM Label l " +
            "JOIN l.todos t " +
            "WHERE t.id = :todoId AND t.user.id = :userId")
    Set<Label> findLabelsByTodoIdAndUserId(@Param("todoId") Long todoId, @Param("userId") Long userId);

}
