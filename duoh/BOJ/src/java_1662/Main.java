package java_1662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static Deque<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray();
        stack = new ArrayDeque<>();

        for (char c : S) {
            stack.push(c);
        }

        System.out.println(decompress());
        br.close();
    }

    private static int decompress() {
        int len = 0;

        while (!stack.isEmpty()) {
            char ch = stack.pop();

            if (ch == ')') {
                int Q = decompress();

                if (!stack.isEmpty()) {
                    int K = stack.pop() - '0';
                    len += K * Q;
                }
            } else if (ch == '(') {
                return len;
            } else {
                len++;
            }
        }

        return len;
    }
}
