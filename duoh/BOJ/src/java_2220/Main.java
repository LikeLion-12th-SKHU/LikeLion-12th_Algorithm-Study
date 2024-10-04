package java_2220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] heap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        heap = new int[n + 1];

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 1) {
                swap(j, j / 2);
                j /= 2;
            }
            heap[1] = i + 1;
        }
        heap[n] = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(heap[i]).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    private static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
