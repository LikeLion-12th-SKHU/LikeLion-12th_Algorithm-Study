package java_1389;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int idx;
    private int sum;

    public Node(int idx, int sum) {
        this.idx = idx;
        this.sum = sum;
    }

    public int getIdx() {
        return this.idx;
    }

    public int getSum() {
        return this.sum;
    }

    @Override
    public int compareTo(Node other) {
        if (this.sum < other.sum) return -1;
        else if (this.sum == other.sum) {
            if (this.idx < other.idx) return -1;
            else if (this.idx == other.idx) return 0;
            else return 1;
        } else return 1;
    }
}

public class Main {
    public static int n, m;
    public static final int INF = (int) 1e9;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 초기화
        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        fw();

        ArrayList<Node> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += graph[i][j];
            }
            array.add(new Node(i, sum));
        }

        Collections.sort(array);

        System.out.println(array.get(0).getIdx());
    }

    public static void init() {
        graph = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }
    }

    public static void fw() {
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }
}
