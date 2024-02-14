import java.util.*;
import java.util.stream.*;

class Solution {
    class Node {
        int num;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node (int n, int x, int y) {
            num = n;
            this.x = x;
            this.y = y;
            left = null;
            right = null;
        }
    }
    
    static int len = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        len = nodeinfo.length;
        Node[] nodeList = new Node[len];
        
        for(int i = 0; i < len; i++) {
            nodeList[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodeList, (n1, n2) -> {
            if(n1.y == n2.y)
                return n1.x - n2.x;
            else
                return n2.y - n1.y;
        });
        
        Node root = nodeList[0];
        for(int i = 1; i < len; i++) {
            buildTree(root, nodeList[i]);
        }
        
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        
        int[][] ans = new int[2][len];
        
        getPreorder(root, preorder);
        getPostorder(root, postorder);
        
        ans[0] = preorder.stream().mapToInt(s -> s).toArray();
        ans[1] = postorder.stream().mapToInt(s -> s).toArray();
        
        return ans;
        // return null;
    }
    
    public void buildTree(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null)
                parent.left = child;
            else
                buildTree(parent.left, child);
        } else {
            if(parent.right == null)
                parent.right = child;
            else
                buildTree(parent.right, child);
        }
    }   
    
    public int findChildIdx(Node[] node, int rootParentX, int rootIdx) {
        int tmp = 0;
        for(int i = rootIdx; i < len; i++) {
            if(rootParentX > node[i].x && node[i].x < node[rootIdx].x){
                tmp = i;
                break;
            }
        }
        return tmp;
    }
    
    public void getPreorder(Node root, List<Integer> preorder) {
        if(root == null)
            return;
        
        preorder.add(root.num);
        
        if(root.left != null)
            getPreorder(root.left, preorder);
        
        if(root.right != null)
            getPreorder(root.right, preorder);
        
        return;
    }
    

    public void getPostorder(Node root, List<Integer> postorder) {
        if(root == null)
            return;
        
        if(root.left != null)
            getPostorder(root.left, postorder);
        
        if(root.right != null)
            getPostorder(root.right, postorder);
        
        postorder.add(root.num);
        
        return;
    }
}