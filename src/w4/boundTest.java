package w4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boundTest {
    static List<Integer> al;
    public static void main(String[] args) {
        al = new ArrayList();
        al.add(1);  // 0
        al.add(2);  // 1
        al.add(4);  // 2
        al.add(4);  // 3
        al.add(4);  // 4
        al.add(5);  // 5
        al.add(6);  // 6

        int index = lowerBound(0, 6, 4);
        System.out.println(index);

        index = upperBound(0, 6, 4);
        System.out.println(index);
    }

    public static int lowerBound(int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) / 2;

            if (al.get(mid) < target)
                low = mid + 1;
            else // target <= mid
                high = mid;
        }
        return high;
    }

    public static int upperBound(int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) / 2;

            if (al.get(mid) <= target)
                low = mid + 1;
            else // target > mid
                high = mid;
        }
        return high;
    }
}
