package java_2812;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            int now = str.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() < now) {
                stack.pop();
                k--;
            }
            stack.push(now);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size() - k; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);
    }
}
