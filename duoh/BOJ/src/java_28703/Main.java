package java_28703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            pq.offer(val);
            max = Math.max(max, val);
        }

        int curMax = max;
        int minDiff = max - pq.peek();

        while (pq.peek() < max) {
            int min = pq.poll();
            minDiff = Math.min(minDiff, curMax - min);
            curMax = Math.max(max, min * 2);
            pq.offer(min * 2);
        }

        System.out.println(Math.min(minDiff, curMax - pq.peek()));
        br.close();
    }
}
