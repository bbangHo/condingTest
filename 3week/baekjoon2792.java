import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        List<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 0;
        int answer = 0;

        for(int i = 0; i < M ; i++){
            arr.add(Integer.parseInt(bf.readLine()));
            right = Math.max(right,arr.get(i));
        }

        while(left <= right){
            int mid = (left+right)/2;
            int sum = 0;

            for(int i = 0 ; i< arr.size(); i++){
                sum+=arr.get(i)/mid;

                if(arr.get(i)%mid !=0)
                    sum++;
            }

            if(sum > N)
                left = mid + 1;

            else{
                right = mid - 1;
                answer = mid;
            }


        }
        System.out.println(answer);


    }
}