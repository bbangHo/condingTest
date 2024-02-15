class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        
        for(int i = 0; i < n; i++) {
            String t = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            while(t.length() < n)
                t = "0" + t;
            
            ans[i] = binaryChange(t, n);
        }
        
        return ans;
    }
    
    public String binaryChange(String str, int n) {
        String tmp = "";
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '1')
                tmp += "#";
            else
                tmp += " ";
        }
        return tmp;
    }
}