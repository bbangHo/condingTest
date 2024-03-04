import java.util.*;

class Solution {
    public long solution(int n, int[] times) {


        long answer = 0;

        answer = binarysearch(times,n, 1,(long) times[times.length-1]*n);
        return answer;
    }

    static long binarysearch(int[] times,int n, long min, long max){
        long answer = 0;
        while(min <=max){
            long sum = 0;
            long mid = (min + max) / 2;

            for(int time: times){
                sum += mid/ time;
            }

            if(sum >=n){
                answer = mid;
                max = mid - 1;
            }
            else{
                min = mid +1;
            }
        }
        return answer;
    }
}