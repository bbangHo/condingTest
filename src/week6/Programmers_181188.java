package week6;
//설명이 필요한 문제
import java.util.Arrays;

public class Programmers_181188 {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int before = 0;
        for(int i=0;i<targets.length;i++){
            if(before <= targets[i][0]){
                before = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
