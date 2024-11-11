package BOJ.src.java_14494;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static long[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        matrix = new long[n + 1][m + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = -1;
            }
        }
        matrix[1][1] = 1;

        //메모이제이션
        System.out.println(dp(n, m) % 1000000007);
    }

    private static long dp(int n, int m) {
        if (matrix[n][m] != -1) return matrix[n][m];
        long result = (dp(n, m-1) + dp(n-1, m) + dp(n-1, m-1)) % 1000000007;
        matrix[n][m] = result;
        return result;
    }
}
