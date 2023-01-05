import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task implements Repitable {


    public AnnualTask(boolean isWork, String title, String description, LocalDateTime time) {
        super(isWork, title, description, time);
    }

    @Override
    public boolean getNextTime(LocalDate date) {
        return date.getDayOfYear() == time.getDayOfYear();
    }
}
