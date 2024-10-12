package java_7569;

import java.util.*;
import java.io.*;

class Node {
    private int x;
    private int y;
    private int z;
    private int stage;

    public Node(int x, int y, int z, int stage) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.stage = stage;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public int getStage() {
        return this.stage;
    }
}

public class Main {
    public static int m, n, h;
    public static int[][][] map;
    public static boolean[][][] visited;
    public static int[] dx = {0, 0, 0, 0, 1, -1};
    public static int[] dy = {0, 1, 0, -1, 0, 0};
    public static int[] dz = {-1, 0, 1, 0, 0, 0};
    public static List<Node> rottenTomatoes = new ArrayList<>();
    public static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];

        // 배열 정보 입력
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) rottenTomatoes.add(new Node(i, j, k, 0));
                }
            }
        }

        // 토마토의 익힘 정도 계산
        for (Node tomato : rottenTomatoes) {
            q.offer(tomato);
        }
        int result = bfs();

        // 토마토가 모두 익었는지 확인
        boolean flag = true;
        outerLoop:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        flag = false;
                        break outerLoop;
                    }
                }
            }
        }

        // 정답 출력
        if (flag) System.out.println(result);
        else System.out.println("-1");
    }

    public static int bfs() {
        int days = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                int nz = now.getZ() + dz[i];
                int stage = now.getStage() + 1;

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < h && ny < n && nz < m) {
                    if (map[nx][ny][nz] == 0) {
                        q.offer(new Node(nx, ny, nz, stage));
                        days = Math.max(days, stage);
                        map[nx][ny][nz] = 1;
                    }
                }
            }
        }
        return days;
    }
}