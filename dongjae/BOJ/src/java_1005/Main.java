package java_1005;

import java.io.*;
import java.util.*;

public class Main {
    public static int t;
    public static int n, k;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] d;
    public static int[] indegree;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < t; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            d = new int[n+1];
            indegree = new int[n+1];
            result = new int[n+1];
            graph = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);

                indegree[b] += 1;
            }

            int w = Integer.parseInt(br.readLine());

            sb.append(topologySort(w)).append("\n");
        }

        System.out.println(sb);
    }

    public static int topologySort(int w) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            result[i] = d[i];
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                result[next] = Math.max(result[next], result[now] + d[next]);
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return result[w];
    }
}