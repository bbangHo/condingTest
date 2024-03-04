import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        int[] AB = new int[n *n];
        int[] CD = new int [n*n];


        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                AB[idx] = A[i]+B[j];
                CD[idx] = C[i]+D[j];
                idx++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int left = 0,  right = n*n-1;
        while(left<n*n && right >=0 ){
            if(AB[left] + CD[right] <0){
                left++;
            }

            else if(AB[left] + CD[right] > 0){
                right--;
            }

            else{
                long leftCnt = 1, rightCnt =1;
                while(left < n*n-1 && AB[left] == AB[left+1]){
                    leftCnt++;
                    left++;
                }
                while(right >0 && CD[right] == CD[right-1]){
                    rightCnt++;
                    right--;
                }

                answer += leftCnt* rightCnt;
                right--;
            }

        }

        System.out.print(answer);
    }
}