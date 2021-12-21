package kosinov;

import java.io.IOException;

/**
 * Main class contains array of domain objects.
 * Cyrillic input/output is demonstrated by setters and getters.
 *
 * @author kosinov-vladyslav
 * @version 1.0
 */
public class Main  {
    /**
     * Main method - entry point of a program.
     *
     * @param args - command line parameters
     * @throws IOException - if there is any unresolved input or output
     */
    public static void main(String[] args) throws IOException {
        /* Array of domain objects */
        int countOfEntries = 2;
        BusStation[] ScheduleEntry = new BusStation[countOfEntries];

        ScheduleEntry[0] = new BusStation();

        /* Initialization (cyrillic input) */
        ScheduleEntry[0].setFlightNumber(120);
        ScheduleEntry[0].setDepartureTime("12:00");
        ScheduleEntry[0].setDayOfTheWeek("Вторник");
        ScheduleEntry[0].setNumberOfFreeSeats(35);
        ScheduleEntry[0].enterRoute(2);

        /* Cyrillic output */

        System.out.println("====================================");
        System.out.print("Запись в расписании #1\n");
        System.out.println("====================================");
        System.out.println("Номер рейса: "
                +ScheduleEntry[0].getFlightNumber());
        System.out.println("Время отправления: "
                + ScheduleEntry[0].getDepartureTime());
        System.out.println("День недели: "
                + ScheduleEntry[0].getDayOfTheWeek());
        System.out.println("Кол-во свободных мест: "
                + ScheduleEntry[0].getNumberOfFreeSeats());

        System.out.print("Маршрут: ");
        for (Flight it : ScheduleEntry[0].getRoute()) {
            System.out.print(it);
            System.out.print("; ");
        }
    }
}