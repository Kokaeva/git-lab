package Lab_2;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StudentService {
    private static Student[] students;

    // Один общий Scanner в UTF-8
    public static final Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    // Статический блок инициализации
    static {
        students = new Student[] {
                new Student("Иван",     true,  "ВУЗ",        "немецкий"),
                new Student("Мария",    false, "школа",      "английский"),
                new Student("Миша",     false, "ВУЗ",        "английский"),
                new Student("Петров",   true,  "Техникум",   "французский"),
                new Student("Сидоров",  true,  "Техникум",   "французский")
        };
    }
    // Заполнение массива с консоли
    public static void fillStudents() {
        System.out.print("Введите количество студентов: ");
        int n = sc.nextInt();
        sc.nextLine(); // очистка буфера после nextInt

        students = new Student[n];
        System.out.println("Введите информацию о студентах:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Студент " + (i + 1) + ":");
            students[i] = new Student();
        }
    }
    // Печать массива
    public static void printStudents() {
        System.out.println("\nСписок студентов:");
        for (Student s : students) {
            System.out.println(s);
        }
    }


}
