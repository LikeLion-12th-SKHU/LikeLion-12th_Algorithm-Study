package java_23841;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.next();
        }
        for (String line : lines) {
            paint(line, m);
        }
        scanner.close();
    }
    public static void paint(String line, int m) {
        StringBuilder sb = new StringBuilder(line);

        for (int i = 0; i < m; i++) {
            if (Character.isLetter(line.charAt(i))) {
                sb.setCharAt(m - i - 1, line.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
