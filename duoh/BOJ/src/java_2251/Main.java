package java_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int MAX = 200;
    private static int A, B, C;
    private static Set<Integer> list;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new TreeSet<>();
        visited = new boolean[MAX + 1][MAX + 1][MAX + 1];

        bfs();
        StringBuilder sb = new StringBuilder();
        for (int li : list) {
            sb.append(li).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, C});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curA = cur[0], curB = cur[1], curC = cur[2];

            if (visited[curA][curB][curC]) continue;
            visited[curA][curB][curC] = true;

            if (curA == 0) list.add(curC);

            // A -> B
            if (curA + curB >= B) {
                q.offer(new int[] {curA - (B - curB), B, curC});
            } else {
                q.offer(new int[] {0, curB + curA, curC});
            }

            // A -> C
            if (curA + curC >= C) {
                q.offer(new int[] {curA - (C - curC), curB, C});
            } else {
                q.offer(new int[] {0, curB, curC + curA});
            }

            // B -> A
            if (curB + curA >= A) {
                q.offer(new int[] {A, curB - (A - curA), curC});
            } else {
                q.offer(new int[] {curA + curB, 0, curC});
            }

            // B -> C
            if (curB + curC >= C) {
                q.offer(new int[] {curA, curB - (C - curC), C});
            } else {
                q.offer(new int[] {curA, 0, curB + curC});
            }

            // C -> A
            if (curC + curA >= A) {
                q.offer(new int[] {A, curB, curC - (A - curA)});
            } else {
                q.offer(new int[] {curC + curA, curB, 0});
            }

            // C -> B
            if (curC + curB >= B) {
                q.offer(new int[] {curA, B, curC - (B - curB)});
            } else {
                q.offer(new int[] {curA, curC + curB, 0});
            }
        }
    }
}
