package algo4editions.chapter1;

public class FixedCapacityStackOfStrings {

    private String[] a;
    private int size;

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public void push(String item) {
        a[size++] = item;
    }

    public String pop() {
        return a[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return a.length == size;
    }


}
