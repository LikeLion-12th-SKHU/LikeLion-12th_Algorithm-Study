package java_2293;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= k; j++) {
                int r = j - arr[i];
                dp[j] += dp[r];
            }
        }

        System.out.println(dp[k]);
    }
}