package ru.geekbrains.lesson1;

public class Cat implements Participants {

    private final double  RUN_DISTANCE;
    private final double  JUMP_HEIGHT;
    private final String NAME = "Кот";

    public Cat(double  runDistance, double  jumpHeight) {
        this.RUN_DISTANCE = runDistance;
        this.JUMP_HEIGHT = jumpHeight;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public double  runDistance() {
        return RUN_DISTANCE;
    }

    @Override
    public double  jumpHeight() {
        return JUMP_HEIGHT;
    }
}
