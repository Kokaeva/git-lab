package Lab_2;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Student {
    private String name;       // фамилия студента
    private boolean hostel;    // нуждается ли в общежитии
    private String end;        // что окончил
    private String lang;       // какой язык изучал


    // Конструктор с параметрами
    public Student(String name, boolean hostel, String end, String lang) {
        this.setName(name);
        this.setHostel(hostel);
        this.setEnd(end);
        this.setLang(lang);
    }

    // Конструктор по умолчанию — ввод с консоли
    public Student() {
        System.out.print("Фамилия: ");
        this.setName(sc.nextLine());

        System.out.print("Нуждается ли в общежитии (true/false): ");
        this.setHostel(sc.nextBoolean());
        sc.nextLine(); // очистка буфера после nextBoolean()

        System.out.print("Что окончил: ");
        this.setEnd(sc.nextLine());

        System.out.print("Какой язык изучал: ");
        this.setLang(sc.nextLine());
    }

    // Геттеры
    public String getName()    { return name; }
    public boolean getHostel() { return hostel; }
    public String getEnd()     { return end; }
    public String getLang()    { return lang; }

    // Сеттеры с проверками
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) System.out.println("Error: пустая фамилия");
        else this.name = name.trim();
    }
    public void setHostel(boolean hostel) { this.hostel = hostel; }
    public void setEnd(String end) {
        if (end == null || end.trim().isEmpty()) System.out.println("Error: пустое значение");
        else this.end = end.trim();
    }
    public void setLang(String lang) {
        if (lang == null || lang.trim().isEmpty()) System.out.println("Error: пустое значение");
        else this.lang = lang.trim();
    }

    @Override
    public String toString() {
        return String.format("Студент: %-10s | Общежитие: %-5s | Окончил: %-10s | Язык: %s",
                name, (hostel ? "да" : "нет"), end, lang);
    }

    // ===== Статические методы для работы с массивом =====

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
}