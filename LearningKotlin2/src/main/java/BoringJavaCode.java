package main.java;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class BoringJavaCode {
    public static void main(String[] args) {

        Object result;

        Integer randomNumber = new Random().nextInt(3);

        if(randomNumber == 1){
            result = new BigDecimal(30);
        } else {
            result = "hello";
        }
        System.out.println("Result is currently " + result);

        if( result instanceof BigDecimal){
            //add 47
            result = ((BigDecimal) result).add(new BigDecimal(47));
        } else {
            //put in into uppercase
            String tempResult = (String)result;
            result = tempResult.toUpperCase();
        }

        System.out.println("Result is currently " + result);

        String aa = "213213";



        solution(3, 1, 3, new int[][]{{1,2,1}, {3,2,1}, {2,4,1}}, new int[]{2, 3});
    }



    public static int solution (int n, int start, int end ,int[][] roads, int[] traps){
        int answer = 0;

        int[] dist = new int[n+1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        boolean[] visit = new boolean[n+1];

        int[][] connections = new int[n+1][n+1];

        for (int[] road : roads) {
            connections[road[0]][road[1]] = road[2];
        }

        visit[start] = true;
        dist[start] = 0;



        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        //0: index, 1: dist

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            visit[now[0]] = true;

            for(int next = 1; next <= n; next++){
                if(connections[now[0]][next] > 0){
                    if(dist[now[0]]+ connections[now[0]][next]< dist[next]){

                    }
                }
            }
        }



        return answer;
    }

}
