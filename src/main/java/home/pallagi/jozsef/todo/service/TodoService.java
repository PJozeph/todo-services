package home.pallagi.jozsef.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import home.pallagi.jozsef.todo.entity.User;
import home.pallagi.jozsef.todo.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import home.pallagi.jozsef.todo.entity.Label;
import home.pallagi.jozsef.todo.entity.Todo;
import home.pallagi.jozsef.todo.model.QueryDTO;
import home.pallagi.jozsef.todo.repository.LabelRepository;
import home.pallagi.jozsef.todo.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    LabelRepository labelRepository;

    public Todo save(Todo todo, Authentication auth) {
        UserDetailsImpl currentUser = (UserDetailsImpl) auth.getPrincipal();
        User user = User.builder().
                id(currentUser.getId()).
                username(currentUser.getUsername()).
                email(currentUser.getEmail()).
                build();
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    public Optional<Todo> getSingle(Long todoId, Long userId) {
        return this.todoRepository.findByUserIdAndId(userId, todoId);
    }

    public List<Todo> getTodosByLabel(Long labelId, Long userId) {
        return this.todoRepository.todosByLabelAndUserId(
                labelId,
                userId
        );
    }

    public Todo update(Todo todo) {
        if (this.todoRepository.findById(todo.getId()).isPresent()) {
            return todoRepository.save(todo);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Todo addLabel(Long todoId, Long labelId, Authentication auth) {
        UserDetailsImpl currentUser = (UserDetailsImpl) auth.getPrincipal();
        Optional<Todo> todo = this.todoRepository.findByUserIdAndId(currentUser.getId(), todoId);
        Optional<Label> labelToAdd = this.labelRepository.findById(labelId);
        if (todo.isPresent() && labelToAdd.isPresent()) {
            Todo updateTodo = todo.get();
            Set<Label> labels = updateTodo.getLabels();
            labels.add(labelToAdd.get());
            updateTodo.setLabels(labels);
            return this.todoRepository.save(updateTodo);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Todo or Label not found");
        }

    }

    public List<Todo> getAll(QueryDTO query, Long userId) {
        return query.getTitle() != null | query.getDescription() != null
                ? this.todoRepository.findByUserIdAndTitleContainingOrDescriptionContaining(userId, query.getTitle(),
                query.getDescription())
                : this.todoRepository.findByUserId(userId);
    }

    public void delete(Long id) {
        this.todoRepository.findById(id).ifPresentOrElse(todo -> {
            this.todoRepository.deleteById(id);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        });

    }

}
