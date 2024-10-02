package java_25497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String skills = br.readLine();

        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackS = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char scan = skills.charAt(i);

            if (Character.isDigit(scan)) {
                count++;
            } else if (scan == 'L') {
                stackL.push(scan);
            } else if (scan == 'S') {
                stackS.push(scan);
            } else if (scan == 'R') {
                if (!stackL.isEmpty()) {
                    stackL.pop();
                    count++;
                } else {
                    break;
                }
            } else if (scan == 'K') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                    count++;
                } else {
                    break;
                }
            }
        }
        br.close();
        System.out.println(count);
    }
}
