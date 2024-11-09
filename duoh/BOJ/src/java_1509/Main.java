package java_1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int size;
    private static char[] ch;
    private static boolean[][] isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ch = br.readLine().toCharArray();
        size = ch.length;
        check();

        int[] dp = new int[size + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        System.out.println(dp[size]);
        br.close();
    }

    private static void check() {
        isPalindrome = new boolean[size + 1][size + 1];

        // 길이 1
        for (int i = 1; i <= size; i++) {
            isPalindrome[i][i] = true;
        }

        // 길이 2
        for (int i = 1; i < size; i++) {
            if (ch[i - 1] == ch[i]) {
                isPalindrome[i][i + 1] = true;
            }
        }

        // 그 이상
        for (int j = 2; j < size; j++) {
            for (int i = 1; i <= size - j; i++) {
                if (ch[i - 1] == ch[i + j - 1] && isPalindrome[i + 1][i + j - 1]) {
                    isPalindrome[i][i + j] = true;
                }
            }
        }
    }
}
