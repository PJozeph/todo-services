package home.pallagi.jozsef.todo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.pallagi.jozsef.todo.entity.Label;
import home.pallagi.jozsef.todo.repository.LabelRepository;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public List<Label> getAll() {
        return this.labelRepository.findAll();
    }

    public Set<Label> getLabelsOfTodo(Long todoId, Long userId) {
        return this.labelRepository.findLabelsByTodoIdAndUserId(todoId, userId);
    }

}
