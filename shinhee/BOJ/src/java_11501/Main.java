package BOJ.src.java_11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            String[] input = br.readLine().split(" ");
            for (int p = 0; p < N; p++) {
                arr[p] = Integer.parseInt(input[p]);
            }

            long max = 0;
            long profit = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (arr[j] > max){
                    max = arr[j];
                }
                else {
                    profit += (max - arr[j]);
                }
            }
            sb.append(profit).append(" ");
        }
        System.out.println(sb);
    }
}
