package week6;

import java.io.*;
import java.util.*;

public class BaekJoon_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bomb = br.readLine();
        int str_len = str.length();
        int bomb_len = bomb.length();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str_len; i++) {
            int count = 0;
            stack.push(str.charAt(i));

            // 스택의 크기가 폭탄 문자열의 길이와 같아지면 탐색 시작
            if(stack.size() >= bomb_len) {

                for(int j=0; j<bomb_len; j++) {

                    if(stack.get(stack.size() - bomb_len + j) == bomb.charAt(j)) {
                        count++;
                    }

                    if(count == bomb_len) {
                        for(int k=0; k<bomb_len; k++) {
                            stack.pop();
                        }
                    }

                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            for(char ch : stack) {
                sb.append(ch);
            }
        }

        System.out.println(sb);

    }
}
