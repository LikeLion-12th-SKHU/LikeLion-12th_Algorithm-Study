package java_17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int R = 0, G = 1, B = 2;
    private static final int SIZE = 3, INF = 1_000 * 1_000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][SIZE];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][R] = Integer.parseInt(st.nextToken());
            cost[i][G] = Integer.parseInt(st.nextToken());
            cost[i][B] = Integer.parseInt(st.nextToken());
        }

        int answer = INF;
        // R, G, B
        for (int k = 0; k < SIZE; k++) {
            int[][] dp = new int[N][SIZE];

            // 처음
            for (int i = 0; i < SIZE; i++) {
                dp[0][i] = i == k ? cost[0][i] : INF;
            }

            // dp
            for (int i = 1; i < N; i++) {
                dp[i][R] = cost[i][R] + Math.min(dp[i - 1][G], dp[i - 1][B]);
                dp[i][G] = cost[i][G] + Math.min(dp[i - 1][R], dp[i - 1][B]);
                dp[i][B] = cost[i][B] + Math.min(dp[i - 1][R], dp[i - 1][G]);
            }

            // 마지막
            for (int i = 0; i < SIZE; i++) {
                if (i != k) {
                    answer = Math.min(answer, dp[N - 1][i]);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
