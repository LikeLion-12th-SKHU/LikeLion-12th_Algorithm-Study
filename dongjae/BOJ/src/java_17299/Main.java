package java_17299;

import java.util.*;
import java.io.*;

class Node {
    private int num;
    private int count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int getNum() {
        return this.num;
    }

    public int getCount() {
        return this.count;
    }
}

public class Main {
    public static int n;
    public static int[] array;
    public static int[] countArr = new int[1000001];
    public static List<Node> infoArr = new ArrayList<>();
    public static Stack<Integer> stack = new Stack<>();
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            array[i] = now;
            countArr[now]++;
        }

        for (int i = 0; i < n; i++) {
            infoArr.add(new Node(array[i], countArr[array[i]]));
        }

        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && infoArr.get(stack.peek()).getCount() < infoArr.get(i).getCount()) {
                result[stack.pop()] = infoArr.get(i).getNum();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}