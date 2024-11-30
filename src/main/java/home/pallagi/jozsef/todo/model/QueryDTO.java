package home.pallagi.jozsef.todo.model;

public class QueryDTO {
    private String title;
    private String description;

    public QueryDTO() {
    }

    public QueryDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
