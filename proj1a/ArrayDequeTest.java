import org.junit.Test;

import java.util.ArrayList;

/**
 * Author: EdisonHo
 * Date: 2022-06-26
 */
public class ArrayDequeTest {

    @Test
    public void testAdd() {
        ArrayDeque<Integer> arrayList = new ArrayDeque<>();

        arrayList.addFirst(10);
        arrayList.addFirst(20);
        arrayList.addFirst(30);
        arrayList.addFirst(40);
        arrayList.addFirst(10);
        arrayList.addFirst(20);
        arrayList.addFirst(30);
        arrayList.addFirst(40);
        arrayList.addFirst(10);
        arrayList.addFirst(20);
        arrayList.addFirst(30);
        arrayList.addFirst(40);
        arrayList.addLast(5);
        arrayList.printDeque();
    }


    @Test
    public void testRemove(){
//        ArrayDeque<Integer> arrayList = new ArrayDeque<>();
//
//        arrayList.addFirst(10);
//        arrayList.addFirst(20);
//        arrayList.addFirst(30);
//        arrayList.addFirst(40);
//        arrayList.removeFirst();
//        arrayList.removeLast();
//        arrayList.printDeque();



    }

    @Test
    public void testGet(){
        ArrayDeque<Integer> arrayList = new ArrayDeque<>();

        arrayList.addFirst(10);
        arrayList.addFirst(20);
        arrayList.addFirst(30);
        System.out.println(arrayList.get(0));
    }
}
