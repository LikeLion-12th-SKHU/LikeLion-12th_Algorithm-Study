package BOJ.src.java_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final Deque<Integer> QUEUE = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    QUEUE.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (QUEUE.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(QUEUE.poll()).append("\n");
                    break;
                case "size":
                    sb.append(QUEUE.size()).append("\n");
                    break;
                case "empty":
                    sb.append(QUEUE.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (QUEUE.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(QUEUE.peek()).append("\n");
                    break;
                case "back":
                    if (QUEUE.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(QUEUE.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
