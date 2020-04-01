package algo4editions.chapter1;

public class LinkedListStack<T> {

    private Node top;
    private int size;

    private class Node {

        T value;
        Node next;
    }

    public void push(T value) {
        Node tempTop = top;
        top = new Node();
        top.value = value;
        top.next = tempTop;
        size++;
    }

    public T pop() {
        Node item = top;
        top = top.next;
        size--;
        T val = item.value;
        item = null;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> l = new LinkedListStack<>();
        l.push(10);
        l.push(11);
        l.push(12);
        l.push(13);

        System.out.println(l.pop());
        System.out.println(l.pop());
        System.out.println(l.pop());
        System.out.println(l.pop());
    }
}
