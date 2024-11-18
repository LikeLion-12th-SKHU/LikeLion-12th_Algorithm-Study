package java_15650;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        visited = new boolean[n];

        comb(0, 0);

        System.out.println(sb);
    }

    public static void comb(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
