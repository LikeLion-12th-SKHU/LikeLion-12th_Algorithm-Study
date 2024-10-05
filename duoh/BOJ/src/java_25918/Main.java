package java_25918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int days = 0;

        for (char s : S) {
            if (!stack.isEmpty() && !stack.peek().equals(s)) {
                stack.pop();
            } else {
                stack.push(s);
            }

            days = Math.max(days, stack.size());
        }

        System.out.println(!stack.isEmpty() ? -1 : days);
        br.close();
    }
}
