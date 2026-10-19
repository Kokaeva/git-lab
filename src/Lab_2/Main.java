package Lab_2;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Принудительно выводим в UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        while (true) {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Заполнить массив студентов");
            System.out.println("2. Распечатать список");
            System.out.println("3. Сколько нуждаются в общежитии");
            System.out.println("4. Изучавшие французский в техникуме");
            System.out.println("5. Упорядочить по фамилиям");
            System.out.println("6. Выход");
            System.out.print("Выбор: ");

            // Теперь обращаемся к сканеру из StudentService
            int choice = StudentService.sc.nextInt();
            StudentService.sc.nextLine(); // очистка буфера

            switch (choice) {
                // Вызываем методы из StudentService
                case 1: StudentService.fillStudents();          break;
                case 2: StudentService.printStudents();         break;
                case 3: StudentService.countHostel();           break;
                case 4: StudentService.listFrenchFromCollege(); break;
                case 5: StudentService.sortByName();            break;
                case 6: System.out.println("Выход.");           return;
                default: System.out.println("Неверный пункт.");
            }
        }
    }
}
