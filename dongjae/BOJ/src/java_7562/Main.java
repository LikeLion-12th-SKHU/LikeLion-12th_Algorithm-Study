package java_7562;

import java.util.*;
import java.io.*;

class Node {
    private int x;
    private int y;
    private int step;

    public Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getStep() {
        return this.step;
    }
}

public class Main {
    public static int t;
    public static int n;
    public static int[][] map;
    public static int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
    public static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            initMap();
            st = new StringTokenizer(br.readLine());
            bfs(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
            st = new StringTokenizer(br.readLine());
            sb.append(map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }
        System.out.println(sb);
    }

    public static void initMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = -1;
            }
        }
    }

    public static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        map[start.getX()][start.getY()] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] == -1) {
                        map[nx][ny] = now.getStep() + 1;
                        q.offer(new Node(nx, ny, map[nx][ny]));
                    }
                }
            }
        }
    }
}
