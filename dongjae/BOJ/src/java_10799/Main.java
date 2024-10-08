package java_10799;

import java.io.*;
import java.util.*;

public class Main {
    public static String str;
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.push(now);
            }
            if (now == ')') {
                stack.pop();
                if (str.charAt(i-1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
