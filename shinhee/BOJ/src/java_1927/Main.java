package BOJ.src.java_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int X;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            X = Integer.parseInt(br.readLine());
            if (X > 0) {
                pQ.add(X);
            } else {
                sb.append(!pQ.isEmpty() ? pQ.poll() : 0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
