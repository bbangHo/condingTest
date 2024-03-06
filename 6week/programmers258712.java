import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int size = friends.length;
        int []recieve = new int[size];
        int []giftmertics = new int[size];
        int [][]giftgraph  = new int[size][size];

        for(String gift: gifts){
            StringTokenizer st = new StringTokenizer(gift);
            String out = st.nextToken();
            String in = st.nextToken();

            int outidx = 0;
            int inidx = 0;
            for(int i =0 ; i <size; i++){
                if(out.equals(friends[i])){
                    giftmertics[i]++;
                    outidx = i;

                }
                if(in.equals(friends[i])){
                    giftmertics[i]--;
                    inidx = i;
                }
            }
            giftgraph[outidx][inidx]++;
        }

        for(int i = 0 ; i< size; i++){
            for(int j = 0 ; j < size; j++){

                if(giftgraph[i][j] == giftgraph[j][i]){
                    if(giftmertics[i] > giftmertics[j])
                        recieve[i]++;
                    else if(giftmertics[i] < giftmertics[j])
                        recieve[j]++;
                }
                else if(giftgraph[i][j] > giftgraph[j][i]){
                    recieve[i]++;
                }
                else if(giftgraph[i][j] < giftgraph[j][i]){
                    recieve[j]++;
                }
            }
        }
        for(int i: recieve){
            answer = Math.max(answer,i);
        }
        answer = answer/2;

        return answer;
    }
}