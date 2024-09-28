package java_1655;

import java.util.*;
import java.io.*;

class MaxComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) return -1;
        else if (o1 == o2) return 0;
        else return 1;
    }
}

public class Main {
    public static int n;
    public static Queue<Integer> minPq = new PriorityQueue<>();
    public static Queue<Integer> maxPq = new PriorityQueue<>(new MaxComparator());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int insert = Integer.parseInt(br.readLine());
            if (minPq.size() == maxPq.size()) maxPq.offer(insert);
            else minPq.offer(insert);

            if (!minPq.isEmpty() && !maxPq.isEmpty()) {
                if (minPq.peek() < maxPq.peek()) {
                    int tmp = maxPq.poll();
                    maxPq.offer(minPq.poll());
                    minPq.offer(tmp);
                }
            }

            sb.append(maxPq.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
