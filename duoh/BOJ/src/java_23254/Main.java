package java_23254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) * 24;
        int M = Integer.parseInt(st.nextToken());
        int[][] subjects = new int[M][2];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            subjects[i][0] = Integer.parseInt(st1.nextToken());
            subjects[i][1] = Integer.parseInt(st2.nextToken());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < M; i++) {
            pq.offer(new int[]{subjects[i][0], subjects[i][1]});
        }

        int total = 0;
        while (N > 0 && !pq.isEmpty()) {
            int[] subject = pq.poll();
            int score = subject[0];
            int growth = subject[1];

            int hours = Math.min(N, (MAX - score) / growth);
            score += growth * hours;

            if (score < MAX) {
                pq.offer(new int[] {score, MAX - score});
            } else {
                total += score;
            }
            N -= hours;
        }

        while (!pq.isEmpty()) {
            total += pq.poll()[0];
        }

        System.out.println(total);
        br.close();
    }
}
