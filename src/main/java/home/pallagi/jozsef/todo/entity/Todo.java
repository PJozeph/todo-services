package home.pallagi.jozsef.todo.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title is mandatory")
    private String title;
    private String description;
    private boolean completed;
    private Date deadline;

    @ManyToOne(fetch = FetchType.LAZY) // Many Todos belong to one User
    @JoinColumn(name = "user_id", nullable = false) // Foreign key in the Todo table
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "todo_label", // Name of the join table
            joinColumns = @JoinColumn(name = "todo_id"), // Foreign key for Todo
            inverseJoinColumns = @JoinColumn(name = "label_id") // Foreign key for Label
    )
    private Set<Label> labels = new HashSet<>();

}
