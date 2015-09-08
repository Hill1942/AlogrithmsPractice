package io.algorithm.basic;

import java.util.Iterator;

/**
 * Created by Kaidi on 2015/9/8.
 */
public class ResizeingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    private void resize(int max) {
        Item[] items = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            items[i] = a[i];
        }
        a = items;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N] = item;
        N++;
    }

    public Item pop() {
        N--;
        Item item = a[N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            i--;
            return a[i];
        }

        public void remove() {

        }
    }
}

