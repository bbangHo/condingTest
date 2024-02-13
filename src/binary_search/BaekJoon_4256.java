package binary_search;

import java.io.*;
import java.util.StringTokenizer;


public class BaekJoon_4256 {
    static StringBuilder sb = new StringBuilder();
    static int[] inorder, preorder;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            inorder = new int[n+1];
            preorder = new int[n+1];

            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++)
                preorder[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++)
                inorder[j] = Integer.parseInt(st.nextToken());

            postOrder(0, 0, n);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    //후위 순회 진행하는 함수
    static void postOrder(int root, int start, int end){
        int r = preorder[root];
        for(int i=start;i<end;i++){
            if(r == inorder[i]){
                postOrder(root+1, start, i);      //Left
                postOrder(root+(i - start + 1), i + 1, end);   //Right
                sb.append(r).append(" ");      //Root
                return;
            }
        }
    }
}