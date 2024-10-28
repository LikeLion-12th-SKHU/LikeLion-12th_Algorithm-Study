package java_1238;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) return -1;
        else if (this.distance == other.distance) return 0;
        else return 1;
    }
}

public class Main {
    public static int n, m, x;
    public static int[][] d;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        d = new int[n+1][n+1];

        // 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 1; j <= n; j++) {
                d[i][j] = 10001;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= n; i++) {
            int twoWay = d[i][x] + d[x][i];
            max = Math.max(max, twoWay);
        }

        System.out.println(max);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        pq.offer(new Node(start, 0));
        d[start][start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.getIndex();
            if (!visited[index]) {
                for (int i = 0; i < graph.get(index).size(); i++) {
                    Node next = graph.get(index).get(i);
                    int cost = d[start][index] + next.getDistance();
                    if (d[start][next.getIndex()] > cost) {
                        d[start][next.getIndex()] = cost;
                        pq.offer(new Node(next.getIndex(), cost));
                    }
                }
                visited[index] = true;
            }
        }
    }
}
