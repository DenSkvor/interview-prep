package ru.geekbrains.interview.prep.lessons.lesson2.linked_list;

public interface LinkedList<E> extends Iterable<E> {

    void insertFirst(E value);

    void insertLast(E value);

    E getFirst();

    E getLast();

    E removeFirst();

    E removeLast();

    boolean remove (E value);

    boolean contains (E value);

    int size();

    boolean isEmpty();

    void display();
}
