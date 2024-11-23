package home.pallagi.jozsef.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.pallagi.jozsef.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByTitleContainingOrDescriptionContaining(String title, String description);

}
