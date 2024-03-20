# 수의 중복이 없는 경우의 UpperBound 주의점
- 문제 특성상 특정 조건의 최대값을 찾는 경우에 UpperBound를 써야하는 상황이 오는데
- 이 때 input으로 들어오는 수 들에 중복이 없다면 주의해야한다.
- 2110 문제를 풀면서 이를 겪었는데,,
  ```
  public static int upperBound(int left, int right, int target) {
      while (left < right) {
          int mid = (left + right) / 2;

          if (al.get(mid) <= target)
              left = mid + 1;
          else // target > mid
              right = mid;
      }
      return right;
  }
  ```
- 4주차에 정리한 UpperBound 코드를 보면 right return 하고있다.
- 정상적인데? 할 수도 있찌만
- [1, 2, 3, 4, 5] 에서 3을 찾는다면, UpperBOund는 4를 return하기 때문에 주의해야한다.
- https://www.acmicpc.net/problem/2110 이 문제를 풀 때 고생을 해서 정리해둔다..