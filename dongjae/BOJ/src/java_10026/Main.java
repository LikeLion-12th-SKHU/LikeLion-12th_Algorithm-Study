package java_10026;

import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 정상인의 눈
        sb.append(checkArea()).append(" ");

        // 색맹의 눈
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }
        sb.append(checkArea());

        System.out.println(sb);
    }

    public static int checkArea() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        visited = new boolean[n][n];
        return count;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char now = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == now) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
