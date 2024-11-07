package java_10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check();
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? 1 : 0).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static void check() {
        dp = new boolean[N + 1][N + 1];

        // 길이 1
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        // 길이 2
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        // 그 이상
        for (int j = 2; j < N; j++) {
            for (int i = 1; i <= N - j; i++) {
                if (arr[i] == arr[i + j] && dp[i + 1][i + j - 1]) {
                    dp[i][i + j] = true;
                }
            }
        }
    }
}
