import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task implements Repitable {


    public DailyTask(boolean isWork, String title, String description, LocalDateTime time) {
        super(isWork, title, description, time);
    }

    @Override
    public boolean getNextTime(LocalDate date) {
        return true;
    }
}
