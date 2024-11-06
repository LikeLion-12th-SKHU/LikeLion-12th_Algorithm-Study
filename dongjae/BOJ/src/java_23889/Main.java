package java_23889;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int idx;
    private long amount;

    public Node(int idx, long amount) {
        this.idx = idx;
        this.amount = amount;
    }

    public int getIdx() {
        return this.idx;
    }

    public long getAmount() {
        return this.amount;
    }

    @Override
    public int compareTo(Node other) {
        if (this.amount < other.amount) return -1;
        else if (this.amount == other.amount) return 0;
        else return 1;
    }
}

public class Main {
    public static int n, m, k;
    public static int[] array;
    public static long[] sumArray;
    public static int[] rockArray;
    public static PriorityQueue<Node> crash = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n+1];
        sumArray = new long[n+1];
        rockArray = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            sumArray[i] = sumArray[i-1] + array[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            rockArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k - 1; i++) {
            long amount = sumArray[rockArray[i+1] - 1] - sumArray[rockArray[i] - 1];
            crash.offer(new Node(rockArray[i], amount));
        }
        crash.offer(new Node(rockArray[k-1], sumArray[n] - sumArray[rockArray[k-1] - 1]));

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(crash.poll().getIdx());
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int x : result) {
            sb.append(x).append("\n");
        }

        System.out.println(sb);
    }
}
