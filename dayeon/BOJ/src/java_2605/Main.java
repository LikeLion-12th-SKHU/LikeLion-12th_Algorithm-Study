package java_2605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int student = i+1;
            int value = nums[i];

            Stack<Integer> tempStack = new Stack<>();
            for (int j = 0; j < value; j++) {
                tempStack.push(stack.pop());
            }

            stack.push(student);

            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }

        Stack<Integer> resultStack = new Stack<>();
        while (!stack.isEmpty()) {
            resultStack.push(stack.pop());
        }
        while (!resultStack.isEmpty()) {
            System.out.print(resultStack.pop() + " ");
        }
    }
}