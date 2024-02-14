import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;

public class Main {
    static int rSize;
    static int cSize;
    static int ans;
    static Set<Set<String>> set;

    public static void main(String[] args) throws IOException {
//        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        String[][] relation = {{"100","100","ryan","music","2"}, {"200","200","apeach","math","2"}, {"300","300","tube","computer","3"}, {"400","400","con","computer","4"}, {"500","500","muzi","music","3"}, {"600","600","apeach","music","2"}};

        rSize = relation.length;
        cSize = relation[0].length;
        set = new HashSet<>();

        for (int i = 0; i < cSize; i++) {
            boolean[] v = new boolean[cSize];
            comb(0, i + 1, v, relation);
        }


        System.out.println(ans);
    }

    public static void comb(int depth, int r, boolean[] visited, String[][] arr) {
        if (r == 0 && candidateKeyIsPossible(arr, visited)) {
            ans++;
            return;
        }

        if (depth == cSize) return;

        visited[depth] = true;
        comb(depth + 1, r - 1, visited, arr);

        visited[depth] = false;
        comb(depth + 1, r, visited, arr);
    }

    public static boolean candidateKeyIsPossible(String[][] arr, boolean[] visited) {
        Set<String> currentSet = new HashSet<>();

        // 데이터 순회하면서
        for (int i = 0; i < rSize; i++) {
            String str = "";

            // 체크해야할 속성만 체크
            for (int k = 0; k < cSize; k++) {
                if (visited[k]) {
                    str += arr[i][k];
                }
            }

            // 유일성 체크
            if (currentSet.contains(str))
                return false;
            else
                currentSet.add(str);
        }

        for(Set<String> s : set) {
            if(s.containsAll(currentSet))
                return false;
        }

        return true;
    }
}