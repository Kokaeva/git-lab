package Lab_2;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
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
}