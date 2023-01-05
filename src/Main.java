import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static Calendar calendar;
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            delTaskId(scanner);
                            break;
                        case 3:
                            getTaskForDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи");
        String description = scanner.nextLine();
        System.out.println("Задача рабочая?");
        boolean isWork;
        switch (scanner.nextLine()) {
            case "рабочая":
                isWork = true;
                break;
            default:
                isWork = false;
        }

        LocalDateTime date;
        System.out.println("Ведите дату дд.мм.гггг. чч:мм:cc");
        date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);

        System.out.println("выбирете повторяемость задачи");
        System.out.println("0 - однократная");
        System.out.println("1 - ежедневная");
        System.out.println("2 - недельная");
        System.out.println("3 - месячная");
        System.out.println("4 - годовая");
        Task task = null;
        switch (scanner.nextInt()) {
            case 0:
                task = new SingleTask(isWork,title,description,date);
            case 1:
                task = new DailyTask(isWork,title,description,date);
                break;
            case 2:
                task = new WeeklyTask(isWork,title,description,date);
                break;
            case 3:
                task = new MonthlyTask(isWork,title,description,date);
                break;
            case 4:
                task = new AnnualTask(isWork,title,description,date);
                break;
        }
        calendar.addTask(task);


    }

    public static void getTaskForDay(Scanner scanner) {
        scanner.nextLine();
        LocalDateTime date = null;
        System.out.println("Ведите дату дд.мм.гггг. чч:мм:cc");
        date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
        System.out.println(calendar.getTask(LocalDate.from(date)));

    }

    public static void delTaskId(Scanner scanner) {
        scanner.nextLine();
        Integer id;
        System.out.println("введите айди который нужно удалить");
        id = scanner.nextInt();
        calendar.delTask(id);

    }



    private static void printMenu() {
        System.out.println(

                        "1. Добавить задачу\n"+
                        "2. Удалить задачу\n" +
                        "3. Получить задачу на указанный день\n"+
                        "0. Выход"

        );
    }
}
