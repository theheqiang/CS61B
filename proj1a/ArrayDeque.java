/**
 * Author: EdisonHo
 * Date: 2022-06-26
 */
public class ArrayDeque<T> {

    private T[] array;
    private static int capacity = 8;
    private int factory = 2;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        array = (T[]) new Object[capacity];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }


    private void resize(int capacity){
        T[] temp = (T[]) new Object[capacity];
        int start = 0;

        for (int i = 0; i < size; i++) {
            temp[i] = array[(nextFirst + i + 1) % ArrayDeque.capacity];
        }

        ArrayDeque.capacity = capacity;

        nextFirst = (start + capacity - 1) % capacity;
        nextLast = (start + size + capacity) % capacity;

        array = temp;
    }

    public void addFirst(T item) {
        if(size == capacity) resize(capacity * factory);
        array[nextFirst] = item;
        size += 1;
        nextFirst = (nextFirst + capacity - 1) % capacity;
    }

    public void addLast(T item) {
        if(size == capacity) resize(capacity * factory);
        array[nextLast] = item;
        size += 1;
        nextLast = (nextLast + 1) % capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {

        for (int i = 0; i < size; i++) {
            System.out.print(array[(nextFirst + i + 1) % capacity] + " ");
        }
    }

    public T removeFirst() {
        if(size == 0) return null;

        nextFirst = (nextFirst + 1) % capacity;
        size -= 1;

        if(capacity >= 16 && (double) size / capacity <= 0.25) resize(capacity /2);

        return array[nextFirst];
    }

    public T removeLast() {
        if(size == 0) return null;

        nextLast = (nextLast + capacity - 1) % capacity;
        size -= 1;

        if(capacity >= 16 && (double) size / capacity <= 0.25) resize(capacity /2);

        return array[nextLast];
    }

    public T get(int index) {
        if(index < 0 || index >= size) return null;
        return array[(nextFirst + index + 1) % capacity];

    }


}
