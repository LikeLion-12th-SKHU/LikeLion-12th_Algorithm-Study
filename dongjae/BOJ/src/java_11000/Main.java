package java_11000;

import java.util.*;
import java.io.*;

class Lecture implements Comparable<Lecture> {
    private int start;
    private int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    @Override
    public int compareTo(Lecture other) {
        if (this.start < other.start) return -1;
        else if (this.start == other.start) {
            if (this.end < other.end) return -1;
            else return 1;
        } else return 1;
    }
}

public class Main {
    public static int n;
    public static List<Lecture> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            array.add(new Lecture(start, end));
        }

        Collections.sort(array);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(array.get(0).getEnd());
        for (int i = 1; i < n; i++) {
            if (!pq.isEmpty() && pq.peek() <= array.get(i).getStart()) {
                pq.poll();
            }
            pq.offer(array.get(i).getEnd());
        }

        System.out.println(pq.size());
    }
}
