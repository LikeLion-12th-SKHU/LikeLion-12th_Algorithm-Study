package java_2468;

import java.io.*;
import java.util.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 100; i++) {
            max = Math.max(max, checkArea(i));
            visited = new boolean[n][n];
        }

        System.out.println(max);
    }

    public static int checkArea(int height) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] > height) {
                    bfs(new Node(i, j), height);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(Node node, int height) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] > height) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
