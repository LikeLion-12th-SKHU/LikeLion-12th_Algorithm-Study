package java_3015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<int[]> stack = new ArrayDeque<>();
        long answer = 0;

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                answer += stack.peek()[1];
                if (stack.peek()[0] == height) {
                    count += stack.peek()[1];
                }
                stack.pop();
            }
            stack.push(new int[]{height, count});

            if (stack.size() > 1) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
