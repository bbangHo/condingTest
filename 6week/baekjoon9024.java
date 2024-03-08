import java.util.*;
import java.io.*;

public class Main{
    static int ABS ;
    static int K;
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        for(int i =0 ; i < t; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int [] arr = new int[n];

            st = new StringTokenizer(bf.readLine());
            for(int j =0 ; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            System.out.println(binarysearch(0, n-1, arr));

        }
    }

    public static int binarysearch(int left , int right, int [] arr){
        int answer = 0;
        ABS = Math.abs(K-(arr[left] + arr[right]));
        while (left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(K - sum) <= ABS){
                if(Math.abs(K - sum) < ABS)
                    answer = 0;
                ABS = Math.abs(K - sum);
                answer++;
            }

            if(sum >= K)
                right= right -1;

            else{
                left = left + 1;
            }

        }
        return answer;
    }
}