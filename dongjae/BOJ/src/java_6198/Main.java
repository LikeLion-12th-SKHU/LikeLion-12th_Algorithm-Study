package java_6198;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static long[] array;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new long[n];

        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            long now = array[i];
            while (!stack.isEmpty() && array[stack.peek()] <= now) {
                stack.pop();
            }
            count += stack.size();
            stack.push(i);
        }

        System.out.println(count);
    }
}
