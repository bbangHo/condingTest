class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int div = 10000;
        int k = x;
        
        while(k > 0) {
            if(k / div == 0)
                div /= 10;
            else {
                sum += k / div;  // 끝 자리 추출
                k %= div;
            }
        }
        
        return x % sum == 0 ? true : false;
    }
}