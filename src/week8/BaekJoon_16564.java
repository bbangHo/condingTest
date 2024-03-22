package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_16564 {
    public static void main(String[] args) throws IOException {
        int[] characters;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        characters = new int[n];
        for(int i=0; i<n; i++){
            characters[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(characters);

        int count = 0;
        while(count < k){
            if(count == n - 1){
                for(int i=0; i<n; i++){
                    characters[i]++;
                    k--;
                }
            }
            else if(characters[count] < characters[count + 1]){
                for(int i=0; i<= count; i++){
                    characters[i]++;
                    k--;
                }
            }
            else if(characters[count] == characters[count + 1])
                count++;
        }

        System.out.println(characters[0]);
    }
}