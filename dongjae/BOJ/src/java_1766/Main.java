package java_1766;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] indegree;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b] += 1;
        }

        topologySort();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    public static void topologySort() {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
