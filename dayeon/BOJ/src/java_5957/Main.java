package java_5957;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dishes = 1;
        Stack<Integer> unWashed = new Stack<>();
        Stack<Integer> unDried = new Stack<>();
        Stack<Integer> clean = new Stack<>();

        for (int i = n; i >= n; i--) {
            unWashed.push(i);
        }

        while (clean.size() != n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int work = Integer.parseInt(st.nextToken());

            if (type == 1) {
                for (int i = 1; i <= work; i++) {
                    unDried.push(dishes++);
                }
            } else if (type == 2) {
                for (int i = 0; i < work; i++) {
                    clean.push(unDried.pop());
                }
            }
        }
        while (!clean.isEmpty()) {
            System.out.println(clean.pop());
        }
        br.close();
    }
}
