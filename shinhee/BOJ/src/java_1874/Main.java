package BOJ.src.java_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;

public class Main { // 스택 수열
    final static ArrayDeque<Integer> STACK = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static int[] INPUT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        INPUT = new int[n];

        for (int i = 0; i < n; i++) {
            INPUT[i] = Integer.parseInt(br.readLine());
        }

        int current = 1;    // 수열 🔺
        int index = 0;

        while (index < n) {
            if (STACK.isEmpty() || STACK.peek() < INPUT[index]) {  // 🔺
                STACK.push(current++);
                sb.append("+\n");
            } else if (STACK.peek() == INPUT[index]){
                STACK.pop();
                sb.append("-\n");
                index++;
            } else {    // 🔺
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
