package home.pallagi.jozsef.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("/{id}")
    Todo getSingle(@PathVariable("id") Long id) {
        return this.todoService.getSingle(id);
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            // String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put("message", errorMessage);
        });
        return errors;
    }

}
