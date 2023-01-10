package ua.kharin.model;

import java.time.LocalDateTime;

public class TestData {
    private int id = 5;
    private String title = "example";
    private LocalDateTime created = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", created=" + created +
                '}';
    }
}
