import java.time.LocalDate;
import java.util.*;

public class Calendar {
    private Map<Integer, Task> taskMap;

    public Calendar() {
        taskMap = new HashMap<>();
    }

    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void delTask(int id) {
        taskMap.remove(id);
    }

    public List<Task> getTask(LocalDate date) {
        List<Task> result = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getValue() instanceof Repitable && (((Repitable) entry.getValue()).getNextTime(date))
            || !(entry.getValue() instanceof Repitable) && entry.getValue().getTime().toLocalDate().equals(date)) {
                result.add(entry.getValue());
            }

        }
        result.sort(Comparator.comparing(Task::getTime));
        return result;
    }


}
