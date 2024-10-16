package java_1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<int[]>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            visited = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(dfs(u, v)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int dfs(int start, int end) {
        if (start == end) return 0;
        visited[start] = true;

        for (int[] nxt : graph[start]) {
            if (!visited[nxt[0]]) {
                int dist = dfs(nxt[0], end);
                if (dist >= 0) return dist + nxt[1];
            }
        }
        return -1;
    }
}