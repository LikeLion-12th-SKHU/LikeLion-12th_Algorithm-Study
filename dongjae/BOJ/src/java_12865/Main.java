package java_12865;

import java.io.*;
import java.util.*;

class Node {
    private int weight;
    private int value;

    public Node(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }
}

public class Main {
    public static int n, k;
    public static int[][] dp;
    public static ArrayList<Node> goods = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        goods.add(new Node(0, 0));
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            goods.add(new Node(w, v));
        }

        dp = new int[k+1][n+1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (goods.get(j).getWeight() > i) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    int r = i - goods.get(j).getWeight();
                    dp[i][j] = Math.max(dp[i][j-1], dp[r][j-1] + goods.get(j).getValue());
                }


            }
        }

        System.out.println(dp[k][n]);
    }
}