import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Task {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss");

    private final boolean isWork;
    private String title;
    private String description;
    LocalDateTime time;
    private static int counter;
    private int id;
    Set<Task> tasksSets = new HashSet<>();


    public Task(boolean isWork, String title, String description, LocalDateTime time) {
        this.isWork = isWork;
        this.title = title;
        this.description = description;
        this.time = time;
        this.id = ++counter;
    }

    public void add(Integer i, String s) {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWork() {
        return isWork;
    }
}
