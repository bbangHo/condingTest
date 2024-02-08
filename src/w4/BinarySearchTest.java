package w4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        List al = new ArrayList();
        al.add(1);  // 0
        al.add(2);  // 1
        al.add(3);  // 2
        al.add(4);  // 3
        al.add(4);  // 4
        al.add(4);  // 5
        al.add(5);  // 6
        al.add(5);  // 7
        al.add(6);  // 8

        int index = Collections.binarySearch(al, 4);
        System.out.println(index);

        index = Collections.binarySearch(al, 6);
        System.out.println(index);
    }
}
