import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Set<String> substr = new HashSet<>();
        int len = 0;
        while(!substr.contains(str)){
            len++;
            for(int i = 0 ; i < str.length()-len+1; i++){

                substr.add(str.substring(i,i+len));

            }
        }
        System.out.print(substr.size());
    }
}