package ru.geekbrains.interview.prep.lessons.lesson2.array_list;

public interface Array<E> extends Iterable<E>{

    void add(E element);

    E get(int index);

    int indexOf(E value);

    boolean remove(E value);

    E remove(int index);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();
}
