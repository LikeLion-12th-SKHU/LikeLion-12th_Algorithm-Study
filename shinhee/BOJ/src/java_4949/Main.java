package BOJ.src.java_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            if (input.equals(".")){
                break;
            }

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }

                if (ch == ')'){
                    if (stack.isEmpty()) {
                        stack.push(ch);
                        break;
                    }
                    if (stack.peek() == '('){
                        stack.pop();
                    } else break;
                } else if (ch == ']') {
                    if (stack.isEmpty()) {
                        stack.push(ch);
                        break;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                    }else break;
                }
            }
            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}
