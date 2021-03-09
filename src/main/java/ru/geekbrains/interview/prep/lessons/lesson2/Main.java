package ru.geekbrains.interview.prep.lessons.lesson2;

import ru.geekbrains.interview.prep.lessons.lesson2.array_list.Array;
import ru.geekbrains.interview.prep.lessons.lesson2.array_list.ArrayImpl;
import ru.geekbrains.interview.prep.lessons.lesson2.linked_list.LinkedList;
import ru.geekbrains.interview.prep.lessons.lesson2.linked_list.LinkedListImpl;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        testArrayList();

        testLinkedList();

    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedListImpl<>();
        for (int i = 0; i < 5; i++) {
            linkedList.insertFirst(4 - i);
            linkedList.insertLast(5 + i);
        }

        for (Integer i : linkedList) {
            System.out.println(i);
        }

        System.out.println("---------");
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(5));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.remove(5));
        System.out.println(linkedList.contains(5));
        System.out.println("---------");

        Iterator<Integer> linkedListIter = linkedList.iterator();

        while (linkedListIter.hasNext()) {
            System.out.println(linkedListIter.next());
            linkedListIter.remove();
        }

        linkedList.display();
    }

    private static void testArrayList() {
        Array<Integer> arrayList = new ArrayImpl<>();
        for (int i = 1; i < 11; i++) {
            arrayList.add(i);
        }

        for (Integer i : arrayList) {
            System.out.println(i);
        }
        System.out.println("--------");
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains(5));
        System.out.println(arrayList.indexOf(5));
        System.out.println(arrayList.get(5));
        System.out.println(arrayList.remove(Integer.valueOf(5)));
        System.out.println(arrayList.contains(5));
        System.out.println(arrayList.remove(1));
        System.out.println("--------");

        Iterator<Integer> arrIter = arrayList.iterator();
        while (arrIter.hasNext()) {
            System.out.println(arrIter.next());
            arrIter.remove();
        }

        arrayList.display();
    }
}
