package java_2923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] countA = new int[MAX];
        int[] countB = new int[MAX];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            countA[a]++;
            countB[b]++;
            sb.append(getMaxSum(countA, countB)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int getMaxSum(int[] countA, int[] countB) {
        int left = 1, right = MAX - 1;
        int lc = countA[left], rc = countB[right];
        int maxSum = 0;

        while (left <= MAX - 1 && right >= 1) {
            while (left < MAX - 1 && lc == 0) {
                left++;
                lc = countA[left];
            }

            while (right > 1 && rc == 0) {
                right--;
                rc = countB[right];
            }

            if (right == 1 && rc == 0) {
                break;
            }

            maxSum = Math.max(maxSum, left + right);

            if (lc <= rc) {
                rc -= lc;
                lc = 0;
            } else {
                lc -= rc;
                rc = 0;
            }
        }

        return maxSum;
    }
}
