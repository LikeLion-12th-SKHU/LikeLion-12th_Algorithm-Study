package java_1504;

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
    public static int n, e;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        d = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        dijkstra(1);
        dijkstra(x);
        dijkstra(y);

        long result1 = (long) d[1][x] + d[x][y] + d[y][n];
        long result2 = (long) d[1][y] + d[y][x] + d[x][n];

        long result = Math.min(result1, result2);

        if (result >= Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        boolean visited[] = new boolean[n+1];
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