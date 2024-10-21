package java_17951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] X = new int[N];
        int left = Integer.MAX_VALUE, right = 0;

        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            left = Math.min(left, X[i]);
            right += X[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0, count = 0;

            for (int x : X) {
                sum += x;
                if (sum >= mid) {
                    sum = 0;
                    count++;
                }
            }

            if (count >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
        br.close();
    }
}
