import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split("-");
        int ans = 0;
        int cnt = 0;



        for(String s: str){
            String[] tmp = s.split("[+]");
            int sum = 0;
            for(String e: tmp){
                sum+=Integer.parseInt(e);
            }
            cnt++;
            if(cnt == 1){
                ans = sum;
            }

            else
                ans-=sum;
        }
        System.out.println(ans);
    }
}