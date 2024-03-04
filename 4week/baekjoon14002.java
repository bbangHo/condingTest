import java.util.*;
import java.io.*;

public class Main{
    static int []mem;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(bf.readLine());
        int []arr = new int[N];
        int [] arrayIndexes = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i =0 ; i <N;i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        mem = new int[N+1];
        mem[0] = 0;

        int len = 0, idx=0;

        for(int i= 0; i <N;i++){
            if(arr[i]> mem[len]){
                len++;
                mem[len] = arr[i];
                arrayIndexes[i] = len;
            }

            else{
                idx = binary(0,len,arr[i]);
                mem[idx] = arr[i];
                arrayIndexes[i] = idx;
            }

        }
        System.out.println(len);

        String printString = "";
        for (int i = N - 1; i >= 0; i--) {
            if (arrayIndexes[i] == len) {
                printString = arr[i] + " " + printString;
                len--;
            }
        }
        System.out.print(printString);




    }
    static int binary(int left, int right, int key){

        while(left < right){
            int mid = (left + right)/2;

            if(mem[mid] < key){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }

        return right;
    }

}