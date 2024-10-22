package java_17245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        StringTokenizer st;
        long total = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
                max = Math.max(max, map[i][j]);
            }
        }

        int left = 0, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    count += Math.min(mid, map[i][j]);
                }
            }

            if (count * 2 >= total) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
        br.close();
    }
}
