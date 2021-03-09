package ru.geekbrains.interview.prep.lessons.lesson2.linked_list;


import java.util.Iterator;

public class LinkedListImpl<E> implements LinkedList<E> {

    private int size;

    private Node first;
    private Node last;


    @Override
    public void insertFirst(E value) {
        first = new Node(value, first, null);
        if (size == 0) last = first;
        else first.next.previous = first;
        size++;
    }

    @Override
    public void insertLast(E value) {
        last = new Node(value,null, last);
        if (size == 0) first = last;
        else last.previous.next = last;
        size++;
    }

    @Override
    public E getFirst() {
        return first == null ? null : first.value;
    }

    @Override
    public E getLast() {
        return last == null ? null : last.value;
    }

    @Override
    public E removeFirst() {
        if (size == 0) return null;
        E returnValue = first.value;
        if (size == 1) first = last = null;
        else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return returnValue;
    }

    @Override
    public E removeLast() {
        if (size == 0) return null;
        E returnValue = last.value;
        if (size == 1) first = last = null;
        else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return returnValue;
    }

    @Override
    public boolean remove(E delValue) {
        if (size == 0) return false;
        Node current = first;
        while (current != null) {
            if (current.value.equals(delValue)) {
                if(size == 1) first = last = null;
                else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(E srchValue) {
        Node current = first;
        while (current != null) {
            if (current.value.equals(srchValue)) return true;
            current = current.next;
        }
        return false;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = first;
        while (current != null) {
            sb.append(current.value.toString()).append(", ");
            current = current.next;
        }
        if (size != 0) sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private class Node {
        private E value;
        private Node next;
        private Node previous;

        Node(E value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private class IteratorImpl implements Iterator<E> {

        private Node cursorNext;
        private Node cursorReaded;
        private int index;
        private int indexDeleted;

        IteratorImpl(){
            cursorNext = first;
        }

        @Override
        public boolean hasNext() {
            return cursorNext != null;
        }

        @Override
        public E next() {
            if(!hasNext()) return null;
            cursorReaded = cursorNext;
            cursorNext = cursorNext.next;
            index++;
            return cursorReaded.value;
        }

        @Override
        public void remove() {
            if(size == 0 || indexDeleted == index) throw new IllegalArgumentException("Некорректный элемент.");
            if(size == 1) {
                first = last = null;
            }
            else if(cursorReaded.previous == null) {
                cursorNext.previous = null;
                first = cursorNext;
            }
            else if(cursorNext == null) {
                cursorReaded.previous.next = null;
                last = cursorReaded.previous;
            }
            else {
                cursorReaded.previous.next = cursorNext;
                cursorNext.previous = cursorReaded.previous;
            }

            size--;
            indexDeleted = index;

        }
    }
}
