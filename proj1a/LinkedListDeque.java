/**
 * Author: EdisonHo
 * Date: 2022-06-26
 */
public class LinkedListDeque<T> {

    private static class Node<T> {
        private T item;
        private Node next;
        private Node prev;

        public Node(T item) {
            this.item = item;
        }

        public Node() {

        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    public void addFirst(T item) {
        Node node = new Node(item);
        sentinel.next.prev = node;
        node.next = sentinel.next;
        node.prev = sentinel;
        sentinel.next = node;
        size += 1;
    }

    public void addLast(T item) {
        Node node = new Node(item);
        sentinel.prev.next = node;
        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev = node;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        int index = 0;
        Node cur = sentinel.next;
        while (index < size) {
            System.out.print(cur.item + " ");
            cur = cur.next;
            index += 1;
        }
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }

        Node p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size -= 1;
        return (T) p.item;
    }

    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }

        Node p = sentinel.prev;

        p.prev.next = sentinel;
        sentinel.prev = p.prev;
        size -= 1;

        return (T) p.item;


    }

    public T get(int index) {
        if(size == 0 || (index < 0 || index >= size)) return null;

        int p = 0;
        Node cur = sentinel.next;
        while (p < index) {
            cur = cur.next;
            p += 1;
        }

        return (T) cur.item;
    }

    private T getRecursive(int index,Node n){
        if(index == 0) return (T) n.item;

        return getRecursive(index-1,n.next);
    }

    public T getRecursive(int index){
        if(size == 0 || (index < 0 || index >= size)) return null;
        return getRecursive(index,sentinel.next);
    }
}
