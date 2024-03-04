import java.util.*;
import java.io.*;

public class Main{
    static final int MIN_SIZE =2;
    static final int DIVISION_SIZE =4;
    static Long[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        arr = new Long[N][N];
        StringTokenizer st;
        for(int i =0 ; i< N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j <N; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }

        }
        System.out.println(find(N,0,0));
    }

    static Long find(int size, int x,int y){
        if(size < MIN_SIZE)
            return arr[x][y];

        int half = size/2;

        Long[] tmp = new Long[DIVISION_SIZE];

        for(int i =0; i< DIVISION_SIZE; i++){
            int px = x+(i%2)*half;
            int py = y+(i/2)*half;

            tmp[i] = find(half, px, py);
        }

        Arrays.sort(tmp);

        return tmp[1];


    }
}