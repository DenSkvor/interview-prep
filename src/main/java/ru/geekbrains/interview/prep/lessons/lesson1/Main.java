package ru.geekbrains.interview.prep.lessons.lesson1;

import ru.geekbrains.interview.prep.lessons.lesson1.task1.Person;
import ru.geekbrains.interview.prep.lessons.lesson1.task2.Circle;
import ru.geekbrains.interview.prep.lessons.lesson1.task2.GeometricalFigure;
import ru.geekbrains.interview.prep.lessons.lesson1.task2.Rectangle;
import ru.geekbrains.interview.prep.lessons.lesson1.task2.Triangle;

public class Main {

    /*Task2
    *
    * - В рамках задачи непонятна идея интерфейсов Moveable и Stopable. Убрать интерфейсы, перенести методы в класс Car.
    *
    * - Методы move(), stop(), open() переопределены безотносительно к специфике конкретного класса.
    * Что у LightWeightCar, что у Lorry используется формулировка "Car is...".
    * Тут либо изменить переопределение на более специфичное, либо реализовать методы в родителе и пользоваться в наследниках этой базовой версией.
    *
    * - Метод start() вообще не используется, поэтому сложно судить о его назначении.
    * Можно сделать его либо abstract и переопределять в наследниках, либо оставить текущую реализацию,
    * но сделать его public, иначе странно не иметь возможности заводить автомобиль полноценно извне.
    * С другой сороны оставить protected имеет смысл, если планируется использовать этот метод только внутри наследников.
    * Например как часть специфичного метода запуска:
    * startLorry(){
    * sout("Поворачиваем ключ.");
    * start();
    * }
    *
    * - В классе Car у поля Engine модификатор доступа заменить на private.
    *
    * - Добавить конструкторы для инициализации полей при создании автомобилей.
    *
    * - У переопределяемого метода open() в классе LightWeightCar модификатор доступа заменить на public.
    *
    * - В классе Lorry интерфейсы Moveable и Stopable должны имплементироваться (implements), а не наследоваться. Должен быть реализован
    * метод open(). Методам move() и stop() из соображения единообразия добавить аннотацию @Override.
    *
    * */

    public static void main(String[] args) {
        doTask1();
        doTask3();
    }

    private static void doTask1() {
        Person person = Person.builder()
                .addFirstName("Денис")
                .addLastName("Скворцов")
                .addAge(30)
                .addAddress("Санкт-Петербург")
                .build();

        System.out.println(person);
    }

    private static void doTask3() {
        GeometricalFigure circle = new Circle(10);
        GeometricalFigure rectangle = new Rectangle(10,5);
        GeometricalFigure triangle = new Triangle(10, 5);

        calcThemAll(circle, rectangle, triangle);
    }

    public static void calcThemAll(GeometricalFigure... figures){
        for (int i = 0; i < figures.length; i++) {
            System.out.println(figures[i].calcArea());
        }
    }
}
