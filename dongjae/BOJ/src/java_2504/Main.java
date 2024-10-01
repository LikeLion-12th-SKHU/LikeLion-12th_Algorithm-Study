package java_2504;

import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Character> stack = new ArrayDeque<>();
    public static int answer, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();

        answer = 0;
        tmp = 1;
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            char now = array[i];
            if (now == '(') {
                tmp *= 2;
                stack.push(now);
            } else if (now == '[') {
                tmp *= 3;
                stack.push(now);
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                if (array[i - 1] == '(') {
                    answer += tmp;
                }
                tmp /= 2;
                stack.pop();
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                if (array[i - 1] == '[') {
                    answer += tmp;
                }
                tmp /= 3;
                stack.pop();
            } else {
                flag = false;
                break;
            }
        }

        if (!stack.isEmpty() || !flag) {
            System.out.println("0");
        } else {
            System.out.println(answer);
        }
    }
}