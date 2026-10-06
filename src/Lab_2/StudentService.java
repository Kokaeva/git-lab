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
}
