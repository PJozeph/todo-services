package home.pallagi.jozsef.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.pallagi.jozsef.todo.entity.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>  {
    
}
