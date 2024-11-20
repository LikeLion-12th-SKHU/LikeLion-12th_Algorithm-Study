package java_15654;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static List<Integer> origin = new ArrayList<>();
    public static boolean[] visited;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        arr = new int[m];

        origin.add(0);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            origin.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(origin);

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = origin.get(i);
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
