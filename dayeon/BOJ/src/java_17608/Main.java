package java_17608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int temp = stack.pop();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (temp < stack.peek()) {
                count++;
                temp = stack.pop();
            } else {
                stack.pop();
            }
        }
        System.out.println(count);
    }
}