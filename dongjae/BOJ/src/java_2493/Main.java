package java_2493;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] array;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int now = array[i];
            while (!stack.isEmpty() && array[stack.peek()] < now) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                sb.append(stack.peek()).append(" ");
            } else {
                sb.append("0").append(" ");
            }

            stack.push(i);
        }

        System.out.println(sb);
    }
}