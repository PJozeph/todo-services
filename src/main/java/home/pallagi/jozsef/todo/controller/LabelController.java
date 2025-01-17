package home.pallagi.jozsef.todo.controller;

import java.util.List;
import java.util.Set;

import home.pallagi.jozsef.todo.entity.Todo;
import home.pallagi.jozsef.todo.security.services.UserDetailsImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.pallagi.jozsef.todo.entity.Label;
import home.pallagi.jozsef.todo.service.LabelService;
import home.pallagi.jozsef.todo.service.TodoService;

@RestController
@RequestMapping("label")
@SecurityRequirement(name = "Bearer Authentication")
public class LabelController {

    @Autowired
    LabelService labelService;

    @Autowired
    TodoService todoService;

    @GetMapping
    List<Label> getLabels() {
        return this.labelService.getAll();
    }

    @GetMapping("/{todoId}")
    Set<Label> getLabelsOfTodo(@PathVariable("todoId") Long todoId, Authentication principal) {
        UserDetailsImpl currentUser = (UserDetailsImpl) principal.getPrincipal();
        return labelService.getLabelsOfTodo(todoId, currentUser.getId());
    }

    @GetMapping("/todos/{labelId}")
    List<Todo> getTodosByLabel(@PathVariable("labelId") Long labelId, Authentication principal) {
        UserDetailsImpl currentUser = (UserDetailsImpl) principal.getPrincipal();
        return todoService.getTodosByLabel(labelId, currentUser.getId());
    }

}
