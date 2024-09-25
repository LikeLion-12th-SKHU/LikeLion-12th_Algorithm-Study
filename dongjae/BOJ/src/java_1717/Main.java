package java_1717;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x == 0) unionParent(a, b);

            if (x == 1) {
                if (findParent(a) == findParent(b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        else {
            parent[x] = findParent(parent[x]);
            return parent[x];
        }
    }

    public static void unionParent(int x, int y) {
        int xP = findParent(x);
        int yP = findParent(y);
        if (xP < yP) parent[yP] = xP;
        else parent[xP] = yP;
    }
}