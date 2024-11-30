package home.pallagi.jozsef.todo.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import home.pallagi.jozsef.todo.entity.Todo;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoRepositoryUnitTests {

    @Autowired
    private TodoRepository todoRepository;

    // @Test
    // @DisplayName("Test 1:Save Todo Test")
    // @Order(1)
    // @Rollback(value = false)
    // public void saveTodoTest() {
    //     Todo employee = new Todo();

    //     todoRepository.save(employee);

    //     Assertions.assertThat(employee.getId()).isGreaterThan(0);
    // }

    @Test
    @Order(2)
    public void getListOfTodoTest() {
        List<Todo> todoList = todoRepository.findAll();

        Assertions.assertThat(todoList.size()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateTodoTest() {
        Todo todo = todoRepository.findById(1L).get();
        todo.setTitle("Sam Curran");
        Todo updatedTodo = todoRepository.save(todo);

        Assertions.assertThat(updatedTodo.getTitle()).isEqualTo("Sam Curran");
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteEmployeeTest() {
        todoRepository.deleteById(1L);
        Optional<Todo> todoOptional = todoRepository.findById(1L);

        Assertions.assertThat(todoOptional).isEmpty();
    }

}
