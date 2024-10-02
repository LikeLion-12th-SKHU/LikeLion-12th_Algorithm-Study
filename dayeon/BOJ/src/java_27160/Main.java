package java_27160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> strawberry = new Stack<>();
        Stack<Integer> banana = new Stack<>();
        Stack<Integer> lime = new Stack<>();
        Stack<Integer> plum = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "STRAWBERRY":
                    strawberry.push(Integer.valueOf(st.nextToken()));
                    break;
                case "BANANA":
                    banana.push(Integer.valueOf(st.nextToken()));
                    break;
                case "LIME":
                    lime.push(Integer.valueOf(st.nextToken()));
                    break;
                case "PLUM":
                    plum.push(Integer.valueOf(st.nextToken()));
                    break;
            }
        }
        if (count(strawberry) == 5 || count(banana) == 5 || count(lime) == 5 || count(plum) == 5) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    private static int count(Stack<Integer> stack) {
        int count = 0;
        while (!stack.isEmpty()) {
            count += stack.pop();
        }
        return count;
    }
}
