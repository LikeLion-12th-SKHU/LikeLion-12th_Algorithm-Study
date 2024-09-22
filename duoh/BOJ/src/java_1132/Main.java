package java_1132;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] alpha = new long[SIZE];
        boolean[] notZero = new boolean[SIZE];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            int len = ch.length - 1;
            notZero[ch[0] - 'A'] = true;

            for (int j = 0; j <= len; j++) {
                alpha[ch[j] - 'A'] += (long) Math.pow(10, len - j);
            }
        }

        long min = Long.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < SIZE; i++) {
            if (!notZero[i] && alpha[i] < min) {
                min = alpha[i];
                minIdx = i;
            }
        }

        alpha[minIdx] = 0;
        Arrays.sort(alpha);
        long ans = 0, mul = 9;

        for (int i = SIZE - 1; i >= 0; i--) {
            ans += alpha[i] * mul--;
        }

        System.out.println(ans);
        br.close();
    }
}
