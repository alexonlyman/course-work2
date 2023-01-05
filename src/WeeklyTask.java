import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repitable {


    public WeeklyTask(boolean isWork, String title, String description, LocalDateTime time) {
        super(isWork, title, description, time);
    }

    @Override
    public boolean getNextTime(LocalDate date) {
       return date.getDayOfWeek() == time.getDayOfWeek();

    }
}
