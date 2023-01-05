import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repitable {

    public MonthlyTask(boolean isWork, String title, String description, LocalDateTime time) {
        super(isWork, title, description, time);
    }

    @Override
    public boolean getNextTime(LocalDate date) {
        return date.getDayOfMonth() == time.getDayOfMonth();
    }
}
