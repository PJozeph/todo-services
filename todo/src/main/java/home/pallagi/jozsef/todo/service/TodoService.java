package home.pallagi.jozsef.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.pallagi.jozsef.todo.entity.Todo;
import home.pallagi.jozsef.todo.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo>getAll() {
        return this.todoRepository.findAll();
    }

}
