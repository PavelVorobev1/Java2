package ru.geekbrains.lesson1;

public class Wall implements Challenge {

    private final double  METER;

    public Wall(double  meter) {
        METER = meter;
    }

    @Override
    public double  meters() {
        return METER;
    }
}
