package home.pallagi.jozsef.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.pallagi.jozsef.todo.entity.Todo;
import home.pallagi.jozsef.todo.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    List<Todo> getTodos() {
        return this.todoService.getAll();
    }

    @PostMapping
    Todo save(Todo todo) {
        return this.todoService.save(todo);
    }

    @PatchMapping
    Todo update(Todo todo) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping
    void delete(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
