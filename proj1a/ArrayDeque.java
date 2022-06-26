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
        this(capacity);
    }


    public ArrayDeque(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public void addFirst(T item) {
        array[nextFirst] = item;
        size += 1;
        nextFirst = (nextFirst + capacity - 1) % capacity;
    }

    public void addLast(T item) {
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
        nextFirst += (nextFirst + 1) % capacity;
        size -= 1;

        return array[nextFirst];
    }

    public T removeLast() {
        nextLast = (nextLast + capacity - 1) % capacity;
        size -= 1;

        return array[nextLast];
    }

    public T get(int index) {

        return array[nextFirst + index + 1];

    }


}
