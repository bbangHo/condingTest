import java.util.*;
import java.io.*;

public class Main{
    static char[][]table;
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        table = new char[R][C];
        for(int i = 0; i < R; i++)
            table[i] = bf.readLine().toCharArray();

        int answer = binarysearch(R,C);
        System.out.print(answer);


    }

    static int binarysearch(int R, int C){
        int start = 0;
        int end = R-1;
        while(start <=end){
            int mid = (start+end)/2;

            if(state(mid,R,C))
                start = mid+1;
            else
                end = mid -1;
        }
        return start;
    }

    static boolean state(int mid, int R, int C){
        Set<String> set = new HashSet<>();
        for(int j = 0; j < C; j++){
            StringBuilder sb = new StringBuilder();
            for(int i = mid+1; i <R; i++){
                sb.append(table[i][j]);
            }

            if(set.contains(sb.toString())){
                return false;
            }


            set.add(sb.toString());

        }
        return true;
    }
}