package java_16940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        StringTokenizer st;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        order = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(order[0] == 1 && bfs() ? 1 : 0);
        br.close();
    }

    private static boolean bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        int idx = 1;

        while (!q.isEmpty()) {
            int x = q.poll();
            int count = 0;

            for (int y : graph[x]) {
                if (!visited[y]) {
                    visited[y] = true;
                    count++;
                }
            }

            for (int i = idx; i < idx + count; i++) {
                if (!visited[order[i]]) {
                    return false;
                } else {
                    q.offer(order[i]);
                }
            }
            idx += count;
        }
        return true;
    }
}
