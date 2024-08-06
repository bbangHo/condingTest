import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();
        String T = bf.readLine();
        StringBuilder sb = new StringBuilder(T);
        for(int i = T.length()-1 ; i >=S.length(); i--){
            if(sb.charAt(i) == 'A'){
                sb.deleteCharAt(i);
            }

            else{
                sb.deleteCharAt(i);
                sb.reverse();
            }

        }

        if(S.equals(sb.toString()))
            System.out.println(1);

        else
            System.out.println(0);


    }
}