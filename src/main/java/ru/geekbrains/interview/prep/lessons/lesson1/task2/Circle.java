package ru.geekbrains.interview.prep.lessons.lesson1.task2;

public class Circle implements GeometricalFigure{

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return 3.14 * radius * radius;
    }

}
