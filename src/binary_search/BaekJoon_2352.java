package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2352 {
    static int n;
    static int[] destination;
    static int[] increaseArr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());

        destination = new int[n + 1];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++){
            int dest = Integer.parseInt(st.nextToken());
            destination[i] = dest;
        }

        increaseArr = new int[n + 1];
        System.out.println(Lis());
    }

    private static int Lis(){
        increaseArr[0] = destination[0];
        int length = 1;

        for(int i = 1; i < n; i++){
            if(increaseArr[length-1] < destination[i]) { //후보값이 마지막값보다 클 때
                increaseArr[length] = destination[i];
                length += 1;
            }
            else { //그 외의 경우엔 바이너리 서치로 넣을 위치를 찾음
                int idx = Arrays.binarySearch(increaseArr, 0, length, destination[i]);
                idx = (idx < 0) ? -idx -1 : idx;
                increaseArr[idx] = destination[i];
            }
        }

       return length;
    }
}
