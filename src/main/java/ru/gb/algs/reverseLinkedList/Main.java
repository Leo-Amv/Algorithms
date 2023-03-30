package ru.gb.algs.reverseLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkList<Integer> numbers = new LinkList<>();
        numbers.addToEnd(6);
        numbers.addToEnd(5);
        numbers.addToEnd(4);
        numbers.addToEnd(3);
        numbers.addToEnd(2);
        numbers.addToEnd(1);
        numbers.addToEnd(1);
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
                    return current!=null;
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
    }
}
