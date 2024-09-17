package java_7983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {d, t});
        }

        int last = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int t = cur[1];

            last = Math.min(last, t) - d;
        }

        System.out.println(last);
        br.close();
    }
}
