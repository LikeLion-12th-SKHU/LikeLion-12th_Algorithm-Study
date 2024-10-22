package java_1987;

import java.util.*;
import java.io.*;

public class Main {
    public static int r, c;
    public static char[][] board;
    public static boolean[] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                board[i][j] = charArr[j];
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }

    public static void dfs(int x, int y, int step) {
        visited[(int) board[x][y] - 'A'] = true;
        max = Math.max(max, step);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[(int) board[nx][ny] - 'A']) {
                    dfs(nx, ny, step + 1);
                }
            }
        }
        visited[(int) board[x][y] - 'A'] = false;
    }
}