package java_9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;
    private static boolean[] visited, finished;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            sb.append(n - count).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        int next = arr[start];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            count++;
            for (int i = next; i != start; i = arr[i]) {
                count++;
            }
        }
        finished[start] = true;
    }
}
