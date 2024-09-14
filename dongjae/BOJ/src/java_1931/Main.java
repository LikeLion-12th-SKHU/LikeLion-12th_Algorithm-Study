package java_1931;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int start;
    private int end;

    public Node(int start, int end) {
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
    public int compareTo(Node other) {
        if (this.end < other.end ) return -1;
        else if (this.end == other.end) {
            if (this.start < other.start) return -1;
            else return 1;
        } else return 1;
    }
}

public class Main {
    public static int n;
    public static List<Node> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            array.add(new Node(start, end));
        }

        Collections.sort(array);

        int count = 0;
        int prevEnd = 0;

        for (int i = 0; i < n; i++) {
            if (prevEnd <= array.get(i).getStart()) {
                prevEnd = array.get(i).getEnd();
                count++;
            }
        }

        System.out.println(count);
    }
}