package ru.geekbrains.lesson3;

public class TestTelephoneDirectory {

    public static void main(String[] args) {

        TelephoneDirectory test = new TelephoneDirectory();

        test.add("+7-000-000-00-00", "Пупкин");
        test.add("+7-111-111-11-11", "Петров");
        test.add("+7-222-222-22-22", "Петров");
        test.add("+7-333-333-33-33", "Санников");
        test.add("+7-444-444-44-44", "Шнайдерман");
        test.add("+7-555-555-55-55", "Китов");
        test.add("+7-666-666-66-66", "Орлов");
        test.add("+7-777-777-77-77", "Попов");
        test.add("+7-888-888-88-88", "Орлов");
        test.add("+7-999-99-99-99", "Козлов");

        test.get("Орлов");
        test.get("Козлов");
        test.get("Петров");

        test.getInfo();

    }


}
