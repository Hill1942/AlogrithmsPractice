package io.algorithm.basic;

/**
 * Created by Kaidi on 2015/9/7.
 */
public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return  N;
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

    private void resize(int max) {
        Item[] items = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            items[i] = a[i];
        }
        a = items;
    }
}
