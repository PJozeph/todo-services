package home.pallagi.jozsef.todo.payload.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private Long id;
    private String type = "Bearer";
    private String username;
    private String email;

}