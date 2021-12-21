package kosinov;

import kosinov.BusStation;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Entry class.
 * Contains entry point of a program.
 *
 * @author kosinov-vladyslav
 */

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static  BusStation[] Entries;
    private static String key = "";

    /**
     * Main method - entry point of a program.
     * Contains user menu for library control.
     *
     * @param args - command line parameters
     * @throws IOException - if there is any unresolved input/output
     */
    public static void main(String[] args) throws IOException {

        /* Processes user's choices. */
        while (!key.equals("5")) {
            /* User menu output. */
            mainMenu();
            key = reader.readLine();
            switch (key) {
                case "1" :
                    System.out.print("\nВведите значение (кол-во записей в расписании): ");
                    Entries = new BusStation[Integer.parseInt(reader.readLine())];
                    break;

                case "2" :
                    init();
                    break;
                case "3" :
                    save();
                    break;
                case "4" :
                    load();
                    break;
                case "5" :
                    System.out.println("Выход...");
                    break;
                default : break;
            }
        }
        reader.close();
    }

    private static void mainMenu() {
        System.out.println("\n---МЕНЮ---");
        System.out.println("1. Определить кол-во элементов массива");
        System.out.println("2. Назначить элементы массива");
        System.out.println("3. Сохранить массив на длительный срок");
        System.out.println("4. Извлечь массив из файла");
        System.out.println("5. Выход");
        System.out.print("Введите свой выбор: ");
    }

    private static void init() throws IOException {
        String init;
        Scanner in = new Scanner(System.in);
        int number = 0;
        for (int i = 0; i < (Entries != null ? Entries.length : 0); i++) {
            System.out.print("\nЗапись в расписании #"+(i+1)+"\n");
            Entries[i] = new BusStation();
            System.out.print("Номер рейса: ");
            number = in.nextInt();
            Entries[i].setFlightNumber(number);
            System.out.print("Время отправления: ");
            init = reader.readLine();
            Entries[i].setDepartureTime(init);
            System.out.print("День недели: ");
            init = reader.readLine();
            Entries[i].setDayOfTheWeek(init);
            System.out.print("Кол-во свободных мест: ");
            number = in.nextInt();
            Entries[i].setNumberOfFreeSeats(number);
            System.out.print("Маршрут: \n");
            System.out.print("Введите кол-во станций входящих в маршрут: ");
            number = in.nextInt();
            Entries[i].enterRoute(number);
        }
        System.out.println();
    }

    private static void save() throws IOException {
        ArrayList<String> hightFolder = new ArrayList<>();
        String pick;
        StringBuilder direct = new StringBuilder("X:\\");
        key = "";
        while(!key.equals("1") && !key.equals("4")) {
            System.out.println("\nТекущий каталог: " + direct.toString());
            System.out.println("1. Сохранить XML-файл в текущем каталоге.");
            System.out.println("2. Перейти в каталог.");
            System.out.println("3. Назад.");
            System.out.println("4. Отмена.");
            System.out.print("Введите ваш выбор: ");
            key = reader.readLine();
            System.out.println();
            switch (key) {
                case "1":
                    String Direct = direct.toString();
                    FileOutputStream fos = new FileOutputStream(Direct + "\\JavaBeans.xml");
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    XMLEncoder xmlEncoder = new XMLEncoder(bos);
                    xmlEncoder.writeObject(Entries);
                    xmlEncoder.close();
                    break;
                case "2":
                    int helpCount = 1;
                    File directory = new File(direct.toString());
                    File[] array = directory.listFiles();
                    ArrayList<File> folders = new ArrayList<>();
                    if (array != null) {
                        for (File it : array) {
                            if (it.isDirectory()) {
                                folders.add(it);
                            }
                        }
                        for (File it : folders) {
                            System.out.println(helpCount++ + ". " + it.getName());
                        }
                        System.out.println();
                        System.out.print("Выберите каталог: ");
                        pick = reader.readLine();
                        hightFolder.add(direct.toString());
                        direct.append(folders.get(Integer.parseInt(pick) - 1).getName()).append("\\");
                    }
                    break;
                case "3":
                    if (direct.length() <= 3) {
                        System.out.println("Вы уже в корневом каталоге!");
                        break;
                    }
                    direct.delete(hightFolder.get(hightFolder.size() - 1).length(),
                    direct.length());
                    hightFolder.remove(hightFolder.size() - 1);
                    break;
                default: break;
            }
        }
    }

    private static void load() throws IOException {
        System.out.println("Введите каталог для извлечения массива в кодировке XML: ");
        String dirToExtract = reader.readLine();
        FileInputStream fis = new FileInputStream(dirToExtract + ".xml");
        BufferedInputStream bis = new BufferedInputStream(fis);
        XMLDecoder xmlDecoder = new XMLDecoder(bis);
        BusStation[] getEntries = (BusStation[]) xmlDecoder.readObject();
        for (int i = 0; i < getEntries.length; i++) {
            System.out.format("Рейс №%d\n", i + 1);
            System.out.println(getEntries[i].toString() + "\n");
        }
        xmlDecoder.close();
    }
}




