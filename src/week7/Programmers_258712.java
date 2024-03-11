package week7;

public class Programmers_258712 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] given_gift;
        int[] taken_gift;
        int[] present;
        int n = friends.length;

        given_gift = new int[n];
        taken_gift = new int[n];
        present = new int[n];

        for(int i = 0; i < gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            for(int j = 0; j < n; j++){
                if(gift[0].equals(friends[j]))
                    given_gift[j]++;
                else if(gift[1].equals(friends[j]))
                    taken_gift[j]++;
            }
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int given_count = 0, taken_count = 0;
                for(int k = 0; k < gifts.length; k++){
                    String[] gift = gifts[k].split(" ");
                    if(friends[i].equals(gift[0]) && friends[j].equals(gift[1]))
                        given_count++;
                    else if(friends[i].equals(gift[1]) && friends[j].equals(gift[0]))
                        taken_count++;
                }
                if(given_count > taken_count)
                    present[i]++;
                else if(given_count < taken_count)
                    present[j]++;
                else{
                    if(given_gift[j] - taken_gift[j] < given_gift[i] - taken_gift[i])
                        present[i]++;
                    else if(given_gift[j] - taken_gift[j] > given_gift[i] - taken_gift[i])
                        present[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(answer < present[i])
                answer = present[i];
        }
        return answer;
    }
}
