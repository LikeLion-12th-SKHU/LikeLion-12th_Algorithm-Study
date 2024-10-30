package java_9694;

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
    public static int t;
    public static int n, m;
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] d;
    public static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            d = new int[m];
            graph = new ArrayList<>();
            prev = new int[m];

            for (int j = 0; j < m; j++) {
                graph.add(new ArrayList<>());
                d[j] = 987654321;
            }

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Node(end, distance));
                graph.get(end).add(new Node(start, distance));
            }

            dijkstra(0);

            sb.append("Case #").append(i+1).append(": ");
            if (d[m-1] >= 987654321) {
                sb.append("-1").append("\n");
            } else {
                String result = backTracking(m-1);
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        boolean[] visited = new boolean[m];
        d[start] = 0;
        prev[start] = -1;
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.getIndex();
            if (!visited[index]) {
                for (int i = 0; i < graph.get(index).size(); i++) {
                    Node next = graph.get(index).get(i);
                    if (!visited[next.getIndex()]) {
                        int cost = d[index] + next.getDistance();
                        if (d[next.getIndex()] > cost) {
                            d[next.getIndex()] = cost;
                            pq.offer(new Node(next.getIndex(), cost));
                            prev[next.getIndex()] = index;
                        }
                    }
                }
                visited[index] = true;
            }
        }
    }

    public static String backTracking(int end) {
        ArrayList<Integer> arr = new ArrayList<>();
        int now = end;
        arr.add(now);
        StringBuilder sb = new StringBuilder();
        while (prev[now] != -1) {
            now = prev[now];
            arr.add(now);
        }

        Collections.reverse(arr);
        for (int x : arr) {
            sb.append(x).append(" ");
        }

        return sb.toString();
    }
}