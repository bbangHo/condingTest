# 증가하는 수열
 - 역추적
 - 1차원 dp를 통해 길이를 유추 할 수 있다면 pair 쌍으로 저장을 한다면 마지막으로 저장된
    (dp에 저장된 현재까지의 가장 긴 수열)에 마지막 위치(인덱스)까지 저장을 하여 역추적으로 찾아갈 수 있음
 -  단 모든 pair쌍은 (0,1)로 초기화=> 0은 역추적을 끝내기 위한 인덱스 번호/ 1은 모든 수는 자기 자신을 포함한 길이가 1임



# LCS
![캡처](https://github.com/bbangHo/condingTest/assets/112802506/11057a46-91fa-4124-b8ac-a1fc1e5a1dd9)
![캡처](https://github.com/bbangHo/condingTest/assets/112802506/1936c04e-584e-4a1f-ab67-3e36620241cb)

# 트리 순회
https://kimjingo.tistory.com/114
![제목 없음](https://github.com/bbangHo/condingTest/assets/112802506/9c91a55e-a31d-4288-aaa2-41b92b8c3470)

	void tree(int start, int end, int pos)//pos는 preorder기준 현재 인덱스 위치
	{
		for (int i = start; i < end; i++)//자식이 없는경우에는 for문이 바로 종료됨
		{
			if (preoder[pos] == inorder[i])//후위 탐색 (왼쪽-> 오른쪽-> print)
			{
				tree(start, i, pos+1);//루트 기준 왼쪽을 탐색
				tree(i+1, end, pos+1 + i -start);
				cout << preoder[pos] << ' ';
			}
		}
	}
