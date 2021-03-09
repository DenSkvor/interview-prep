package ru.geekbrains.interview.prep.lessons.lesson2.array_list;


import java.util.Arrays;
import java.util.Iterator;

public class ArrayImpl<E> implements Array<E> {

    private E[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 8;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int capacity) {
        if (capacity == 0) capacity = DEFAULT_CAPACITY;
        data = (E[]) new Object[capacity];
    }

    @Override
    public void add(E element) {
        if(size == data.length){
            data = Arrays.copyOf(data, size * 2);
        }
        data[size++] = element;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return data[index];
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(value)) return i;
        }
        return -1;
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if(index == -1) return false;
        if(size > 1) System.arraycopy(data, index + 1, data, index, size - (index + 1));
        data[--size] = null;
        return true;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E value = data[index];
        if(size > 1) System.arraycopy(data, index + 1, data, index, size - (index + 1));
        data[--size] = null;
        return value;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.append(size == 0 ? "" : data[size - 1]).append("]");
        return sb.toString();
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException(String.format("Неверный индекс - %d. Max индекс = %d", index, size - 1));
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E>{
        private int indexNext;
        private int indexReaded;

        IteratorImpl(){
            indexReaded = -1;
        }

        @Override
        public boolean hasNext() {
            return indexNext < data.length && data[indexNext] != null;
        }

        @Override
        public E next() {
            indexReaded = indexNext++;
            return data[indexReaded];
        }

        @Override
        public void remove() {
            if(indexReaded == -1 || data[indexReaded] == null) throw new IllegalArgumentException(String.format("Некорректный элемент. Индекс - %d.", indexReaded));
            data[indexReaded] = null;
            size--;
        }

    }
}
