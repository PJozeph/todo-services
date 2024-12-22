package home.pallagi.jozsef.todo.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    private Long id;

    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Todo> todos = new HashSet<>();

}
