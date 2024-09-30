package java_1918;

import java.io.*;
import java.util.*;

public class Main {
    public static char[] array;
    public static Deque<Character> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') stack.push(array[i]);
            else if (array[i] == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (array[i] == '*' || array[i] == '/' || array[i] == '+' || array[i] == '-') {
                while (!stack.isEmpty() && precedence(array[i]) <= precedence(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(array[i]);
            } else {
                sb.append(array[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    public static int precedence(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}