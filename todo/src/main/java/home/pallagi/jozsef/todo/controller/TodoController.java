package home.pallagi.jozsef.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.pallagi.jozsef.todo.entity.Todo;
import home.pallagi.jozsef.todo.model.QueryDTO;
import home.pallagi.jozsef.todo.service.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    List<Todo> getTodos(@ModelAttribute QueryDTO query) {
        return this.todoService.getAll(query);
    }

    @PostMapping
    Todo save(@Valid @RequestBody Todo todo) {
        return this.todoService.save(todo);
    }

    @PatchMapping
    Todo update(Todo todo) {
       return this.todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.todoService.delete(id);
    }

}
