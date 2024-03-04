import java.util.*;
import java.io.*;

public class Main{
    static int[] pre;
    static int[] in;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i< T; i++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            pre = new int[N];
            in = new int[N];

            st = new StringTokenizer(bf.readLine());
            for(int j = 0 ; j<N;j++){
                pre[j] = Integer.parseInt(st.nextToken());
            }


            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++){
                in[j] = Integer.parseInt(st.nextToken());
            }

            findpost(0,0,N-1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    static void findpost(int rootidx, int start, int end){
        if(rootidx>=N){
            return;
        }

        int root =pre[rootidx];

        for(int i = start; i <=end; i++ ){
            if(root==in[i]){
                findpost(rootidx+1,start,i); // preorder에서 왼쪽 서브트리 범위는 start +1 ~ i가 맞지만 
                //그렇게 재귀호출하면 왼쪽서브트리로 재귀호출해 내려갈수록 if(root == in[i])에서 일치하는 조건 찾을 수 없어진다(크게 봤을때 inOrder에서는 왼쪽 서브트리는 (처음 ~ i-1))  그래서 결국 계속해서 재귀 호출해 나갈때 inOrder 범위도 생각해야하기 때문에 이렇게 한다 -> 왼쪽호출했다 오른쪽 하는 경우에도 생각해보면 마찬가지로 왼쪽을 저렇게 호출하도록해야 if조건이 찾아짐
                findpost(rootidx+i+1-start,i+1, end);
                sb.append(root +" ");
                return;
            }
        }

    }
}