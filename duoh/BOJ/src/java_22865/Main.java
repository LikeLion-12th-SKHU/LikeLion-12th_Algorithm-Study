package java_22865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = 100_000 * 10_000 + 1;
    private static List<Node>[] graph;
    private static int N, A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            graph[D].add(new Node(E, L));
            graph[E].add(new Node(D, L));
        }

        System.out.println(search());
        br.close();
    }

    private static int search() {
        int[] distA = dijkstra(A);
        int[] distB = dijkstra(B);
        int[] distC = dijkstra(C);
        int ans = 0, farthest = 0;

        for (int i = 1; i <= N; i++) {
            if (i == A || i == B || i == C) continue;

            int shortest = Math.min(Math.min(distA[i], distB[i]), distC[i]);
            if (farthest < shortest) {
                farthest = shortest;
                ans = i;
            }
        }
        return ans;
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;

            for (Node next : graph[cur.v]) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
}

class Node {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}