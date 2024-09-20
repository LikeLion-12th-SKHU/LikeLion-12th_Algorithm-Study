package java_1202;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int m;
    private int v;

    public Node(int m, int v) {
        this.m = m;
        this.v = v;
    }

    public int getM() {
        return this.m;
    }

    public int getV() {
        return this.v;
    }

    @Override
    public int compareTo(Node other) {
        if (this.m < other.m) return -1;
        else if (this.m == other.m) {
            if (this.v < other.v) return 1;
            else if (this.v == other.v) return 0;
            else return -1;
        } else return 1;
    }
}

public class Main {
    public static int n, k;
    public static List<Node> array = new ArrayList<>();
    public static List<Integer> bags = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            array.add(new Node(weight, value));
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            bags.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(array);
        Collections.sort(bags);

        long result = 0;
        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (idx < n && array.get(idx).getM() <= bags.get(i)) {
                pq.offer(array.get(idx).getV());
                idx++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}