import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] str = bf.readLine().toCharArray();
        String bomb = bf.readLine();
        List<Character> afterstr = new ArrayList<>();

       for(int i = 0 ; i < str.length; i++){
           afterstr.add(str[i]);

           if(afterstr.size() >= bomb.length()){
               boolean state = true;
               for(int j = 0; j < bomb.length(); j++){
                   if(afterstr.get(afterstr.size()- bomb.length() + j)!=bomb.charAt(j)){
                       state = false;
                       break;
                   }
               }
               if(state){
                   for (int j = 0; j < bomb.length();j++){
                       afterstr.remove(afterstr.size()- 1);
                   }
               }
           }
       }
       if(afterstr.size() ==0)
           System.out.println("FRULA");
       else{
           StringBuilder sb = new StringBuilder(afterstr.size());
           for (char ch : afterstr) {
               sb.append(ch);
           }
           System.out.println(sb.toString());
       }

    }

}