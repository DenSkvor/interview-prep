package ru.geekbrains.interview.prep.lessons.lesson1.task2;

public class Triangle implements GeometricalFigure {

    private final double height;
    private final double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double calcArea() {
        return 0.5 * height * base;
    }

}
