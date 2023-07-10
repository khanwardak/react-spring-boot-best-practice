package khan.cpm.fullstackcrudapp;

import java.time.LocalDate;

public class Todo {
    public Todo(){

    }
    private  int id;
    private  String username;
    private  String description;
    private boolean isdone;
    private  LocalDate localDate;

    public Todo(int id, String username, String description, boolean isdone, LocalDate localDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.isdone = isdone;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsdone() {
        return isdone;
    }

    public void setIsdone(boolean isdone) {
        this.isdone = isdone;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", isdone=" + isdone +
                ", localDate=" + localDate +
                '}';
    }
}
