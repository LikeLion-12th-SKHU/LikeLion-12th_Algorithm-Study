package java_1261;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public int compareTo(Node other) {
        if (this.count < other.count) return -1;
        else if (this.count == other.count) return 0;
        else return 1;
    }
}

public class Main {
    public static int m, n;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[][] countInfo;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        countInfo = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(new Node(0, 0, 0));

        System.out.println(countInfo[n-1][m-1]);
    }

    public static void bfs(Node start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(start);
        visited[start.getX()][start.getY()] = true;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.getX();
                int ny = dy[i] + now.getY();
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (graph[nx][ny] == 1) {
                            pq.offer(new Node(nx, ny, now.getCount() + 1));
                            countInfo[nx][ny] = now.getCount() + 1;
                        } else {
                            pq.offer(new Node(nx, ny, now.getCount()));
                            countInfo[nx][ny] = now.getCount();
                        }
                    }
                }
            }
        }
    }
}
