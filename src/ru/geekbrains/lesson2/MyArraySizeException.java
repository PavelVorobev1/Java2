package ru.geekbrains.lesson2;

public class MyArraySizeException extends RuntimeException{

    public MyArraySizeException() {
        super("Колчество строк и столбцов не должно быть больше 4.");
    }
}
