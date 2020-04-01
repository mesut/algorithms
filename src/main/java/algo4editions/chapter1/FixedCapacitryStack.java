package algo4editions.chapter1;

import org.omg.CORBA.Object;

import java.util.Iterator;

public class FixedCapacitryStack<T> implements Iterable<T> {

    private T[] array;
    private int size;

    public FixedCapacitryStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (array.length == size) {
            resize(array.length * 2);
        }
        array[size++] = item;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for(int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public T pop() {
        T item = array[--size];
        array[size] = null; //loitering. tell the garbage collector to remove from memory. it will be never accessed.overwrited.
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public T next() {
            return array[--size];
        }
    }
}
