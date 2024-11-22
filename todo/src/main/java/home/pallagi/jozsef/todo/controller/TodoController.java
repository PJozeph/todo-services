package home.pallagi.jozsef.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(this.todoService.getAll());
    }

    @PostMapping
    ResponseEntity<Todo> save(Todo todo) {
        return ResponseEntity.ok(this.todoService.save(todo));
    }

    @PatchMapping
    Todo update(Todo todo) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.todoService.delete(id);
    }

}
