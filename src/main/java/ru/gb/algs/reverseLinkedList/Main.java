package ru.gb.algs.reverseLinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkList<Integer> numbers = new LinkList<>();
        numbers.addToEnd(6);
        numbers.addToEnd(5);
        numbers.addToEnd(4);
        numbers.addToEnd(3);
        numbers.addToEnd(2);
        numbers.addToEnd(1);
        for (int num : numbers) {
            System.out.printf(num + " ");
        }
        System.out.println();
        numbers.reverse();
        for (int num : numbers) {
            System.out.printf(num + " ");
        }
    }

    public static class LinkList<T> implements Iterable<T> {
        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {
            T data;
            ListItem<T> next;

        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}
