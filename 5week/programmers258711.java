class Solution {
    public int[] solution(int[][] edges) {
        int [] indegree = new int[1000001];
        int [] outdegree = new int[1000001];

        int maxNode = 0;

        for(int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];

            maxNode = Math.max(maxNode,Math.max(start,end));

            indegree[end]++;
            outdegree[start]++;
        }


        int[] answer = new int[4];

        for(int node = 1; node <=maxNode; node++){
            if(outdegree[node] >= 2 &&indegree[node] == 0)
                answer[0] = node;
            else if(outdegree[node] == 2 && indegree[node] >=2)
                answer[3]++;
            else if(outdegree[node] == 0)
                answer[2]++;
        }

        answer[1] = outdegree[answer[0]]- (answer[2] + answer[3]);



        return answer;
    }
}