package java_9935;

import java.util.*;
import java.io.*;

public class Main {
    public static String str;
    public static String expStr;
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        expStr = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= expStr.length() && check()) {
                explode();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }

    public static boolean check() {
        boolean flag = true;

        for (int i = 0; i < expStr.length(); i++) {
            if (stack.get(stack.size() - 1 - i) != expStr.charAt(expStr.length() - 1 - i)) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void explode() {
        for (int i = 0; i < expStr.length(); i++) {
            stack.pop();
        }
    }
}
