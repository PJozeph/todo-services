package home.pallagi.jozsef.todo.service;

import home.pallagi.jozsef.todo.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.security.Principal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

import home.pallagi.jozsef.todo.entity.Todo;
import home.pallagi.jozsef.todo.repository.TodoRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.security.core.Authentication;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoServiceUnitTests {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    private Todo todo;

    private Validator validator;

    @BeforeEach
    public void setup() {
        todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Test Todo");
        todo.setDescription("Test Description");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @Order(1)
    public void saveTodoTest() {
        given(todoRepository.save(todo)).willReturn(todo);
        Authentication auth = Mockito.mock(Authentication.class);
        UserDetailsImpl userDetails = new UserDetailsImpl(1L,
                "test"
                , "email@test"
                , "test");
        Mockito.when(auth.getPrincipal()).thenReturn(userDetails);

        Todo savedTodo = todoService.save(todo, auth);

        assertThat(savedTodo).isNotNull();
    }

    @Test
    @Order(2)
    public void throwExceptionWhenTodoTitleIsNull() {
        Todo todo = new Todo();
        todo.setTitle(null);

        Set<ConstraintViolation<Todo>> violations = validator.validate(todo);

        assertThat(violations.size()).isEqualTo(1);
    }

    // @Test
    // @Order(3)
    // public void addLabelToTodoTest() {
    //     given(todoRepository.findById(1L)).willReturn(java.util.Optional.of(todo));

    //     Todo updatedTodo = todoService.addLabel(1L, 1L);

    //     assertThat(updatedTodo.getLabels().size()).isEqualTo(1);
    // }

}
