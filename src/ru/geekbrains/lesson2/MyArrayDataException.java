package ru.geekbrains.lesson2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException() {
        super("Неверный формат ввода чисел.");
    }
}
