package Lab_2;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
                new Student("Саша",   true,  "Техникум",   "французский"),
                new Student("Анита",  true,  "Техникум",   "французский")
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
    // Задание a: сколько человек нуждаются в общежитии
    // задание а
    public static void countHostel() {
        int count = 0;
        for (Student s : students) {
            if (s.getHostel()) count++;
        }
        System.out.println("Нуждаются в общежитии: " + count + " чел.");
    }
    // Задание b: студенты, изучавшие французский язык в техникуме
    // задание b
    public static void listFrenchFromCollege() {
        System.out.println("\nИзучавшие французский язык в техникуме:");
        boolean found = false;
        for (Student s : students) {
            if (s.getLang().equalsIgnoreCase("французский")
                    && s.getEnd().toLowerCase().contains("техникум")) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("Не найдено.");
    }
    // Задание c: сортировка по фамилиям
    // задание c
    public static void sortByName() {
        Arrays.sort(students, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        System.out.println("Массив упорядочен по фамилиям.");
    }
    public static Student findByName(String name){
        System.out.println("Поиск в feature:" + name);
        for(Student s: students){
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }
    public static Student searchByName(String name){
        System.out.println("Поиск в master:" + name);
        for(Student s: students){
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }


}
