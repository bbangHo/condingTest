import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [][]target = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            target[i][0] = start;
            target[i][1] = end;
        }

        Arrays.sort(target,(o1, o2)->{
            if(o1[1] == o2[1]) //이 경우는 생각 못했음..
                return o1[0] - o2[0];
            return o1[1]-o2[1];
        });

        int x =0;
        int ans = 0;
        for(int i = 0; i < N; i++){
            if(x <= target[i][0]){
                x = target[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }


}