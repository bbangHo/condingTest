package week5;

import java.util.ArrayList;
import java.util.List;

public class Programmers_258711 {
    static int N = 1000000;

    public static void main(String[] args) {
        int[][] edges;

        edges = new int[100][100];
        solution(edges);
    }

    public static int[] solution(int[][] edges) {
        int[] ingoing = new int[N];
        int[] outgoing = new int[N];
        for(int[] edge : edges) {
            outgoing[edge[0]-1]++;
            ingoing[edge[1]-1]++;
        }
        int created = 0;
        int eight = 0;
        int stick = 0;
        for(int i=0; i<N; i++) {
            if(outgoing[i] >= 2) {
                if(ingoing[i] == 0) {
                    created = i;
                }else {
                    eight++;
                }
            }else if(outgoing[i] == 0 && ingoing[i] > 0){
                stick++;
            }
        }
        return new int[] {created+1,outgoing[created]-eight-stick,stick,eight};
    }
}
