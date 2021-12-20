package ru.geekbrains.lesson1;

public class Treadmill implements Challenge {

    private final double  METER;

    public Treadmill(double  meter) {
        METER = meter;
    }

    @Override
    public double  meters() {
        return METER;
    }
}
