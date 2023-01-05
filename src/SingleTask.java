import java.time.LocalDateTime;

public class SingleTask extends Task {

    public SingleTask(boolean isWork, String title, String description, LocalDateTime time) {
        super(isWork, title, description, time);
    }
}
