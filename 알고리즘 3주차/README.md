# 2진탐색

내가 찾고자 하는값 : target

홀수개든 짝수개든 모두 상관없이 시행됨

- 찾고자 하는 값을 기준으로 high를 좁히는 경우
  
while(low <= high){
 
    if(x >= target) //target이 일치하는 경우를 high로 좁힘 
  
    high = mid - 1;
    
    else if(x < target)
  
    low = mid + 1;
    
}

 while문 종료시 -> 내가 원하는 값 target의 인덱스는 low가 자리잡음

- 찾고자 하는 값을 기준으로 low을 좁히는 경우

  while(low <= high){
  
      if(x > target)//target이 일치하는 경우를 low로 좁힘
  
      high = mid - 1;
  
      else if(x <= target)
  
      low = mid + 1;
  
}

while문 종료시 -> 내가 원하는 값 target의 인덱스는 high가 자리잡음
