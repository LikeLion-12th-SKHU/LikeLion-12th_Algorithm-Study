package java_12886;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int A, B, C;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if ((A + B + C) % 3 != 0) {
            System.out.println(0);
            return;
        }

        visited = new boolean[1501][1501];
        System.out.println(bfs() ? 1 : 0);
        br.close();
    }

    private static boolean bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{A, B, C});
        visited[A][B] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1], c = cur[2];

            if (a == b && b == c) return true;

            // A와 B
            if (a < b && !visited[a + a][b - a]) {
                q.offer(new int[]{a + a, b - a, c});
                visited[a + a][b - a] = true;
            } else if (a > b && !visited[b + b][a - b]) {
                q.offer(new int[]{a - b, b + b, c});
                visited[b + b][a - b] = true;
            }

            // A와 C
            if (a < c && !visited[a + a][c - a]) {
                q.offer(new int[]{a + a, b, c - a});
                visited[a + a][c - a] = true;
            } else if (a > c && !visited[c + c][a - c]) {
                q.offer(new int[]{a - c, b, c + c});
                visited[c + c][a - c] = true;
            }

            // B와 C
            if (b < c && !visited[b + b][c - b]) {
                q.offer(new int[]{a, b + b, c - b});
                visited[b + b][c - b] = true;
            } else if (b > c && !visited[c + c][b - c]) {
                q.offer(new int[]{a, b - c, c + c});
                visited[c + c][b - c] = true;
            }
        }
        return false;
    }
}
