package java_1464;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray();
        final int len = S.length;

        Deque<Character> deque = new ArrayDeque<>();
        deque.offer(S[0]);

        for (int i = 1; i < len; i++) {
            if (deque.peekLast() < S[i]) {
                deque.offerFirst(S[i]);
            } else {
                deque.offer(S[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }

        System.out.println(sb);
        br.close();
    }
}
