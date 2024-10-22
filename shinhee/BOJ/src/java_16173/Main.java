package BOJ.src.java_16173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    private static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0, 1}, dy = {1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println("Hing");
    }

    private static void dfs(int i, int j) {
        if (matrix[i][j] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int k = 0; k < 2; k++) {
            int x = i + dx[k] * matrix[i][j];
            int y = j + dy[k] * matrix[i][j];
            if(x>=N || y>=N || visited[x][y]) continue;

            visited[x][y] = true;
            dfs(x, y);
        }
    }
}
