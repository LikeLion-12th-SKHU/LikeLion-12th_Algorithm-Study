package java_1516;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] indegree;
    public static int[] time;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static long[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        indegree = new int[n+1];
        time = new int[n+1];
        result = new long[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if (x != -1) {
                    graph.get(x).add(i);
                    indegree[i] += 1;
                }
            }
        }

        topologySort();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
            result[i] = time[i];
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                result[next] = Math.max(result[next], result[now] + time[next]);
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}