package java_14627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[S];
        long total = 0L;
        int max = 0;

        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
            max = Math.max(max, arr[i]);
        }

        int left = 1, right = max, best = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int a : arr) {
                count += a / mid;
            }

            if (count >= C) {
                best = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(total - (long) best * C);
        br.close();
    }
}
