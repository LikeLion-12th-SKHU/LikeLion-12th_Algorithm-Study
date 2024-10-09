package BOJ.src.java_2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        br.close();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        sb.append("1 ");
        int index = arr[0];

        for (int i = 1; i < N; i++) {
            deque.add(new int[]{(i + 1), arr[i]});
        }

        while (!deque.isEmpty()) {
            if (index > 0) {
                for (int i = 1; i < index; i++) {
                    deque.add(deque.poll());
                }
                int[] nxt = deque.poll();
                index = nxt[1];
                sb.append(nxt[0] + " ");
            } else {
                for(int i = 1; i < -index; i++) {
                    deque.addFirst(deque.pollLast());
                }

                int[] nxt = deque.pollLast();
                index = nxt[1];
                sb.append(nxt[0]).append(" ");
            }
        }
        System.out.println(sb);
    }
}