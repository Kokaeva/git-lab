package Lab_2;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Принудительно выводим в UTF-8 — убирает «кракозябры» при выводе
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

            int choice = Student.sc.nextInt();
            Student.sc.nextLine(); // очистка буфера после nextInt

            switch (choice) {
                case 1: Student.fillStudents();           break;
                case 2: Student.printStudents();          break;
                case 3: Student.countHostel();            break;
                case 4: Student.listFrenchFromCollege();  break;
                case 5: Student.sortByName();             break;
                case 6: System.out.println("Выход.");     return;
                default: System.out.println("Неверный пункт.");
            }
        }
    }
}