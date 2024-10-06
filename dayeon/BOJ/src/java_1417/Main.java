package java_1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        int my = Integer.parseInt(br.readLine());
        for (int i = 0; i < n-1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() >= my) {
            pq.offer(pq.poll()-1);
            my++;
            count++;
        }

        System.out.println(count);
    }
}
