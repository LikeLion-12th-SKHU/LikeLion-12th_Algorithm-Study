package BOJ.src.java_10828;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int[] STACK = new int[N];

        StringBuilder sb = new StringBuilder();

        int pointer = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    pointer++;
                    push(Integer.parseInt(st.nextToken()), STACK, pointer);
                    break;
                case "pop":
                    sb.append(pop(STACK, pointer)).append("\n");
                    if (pointer > -1) pointer--;
                    break;
                case "size":
                    sb.append(size(pointer)).append("\n");
                    break;
                case "empty":
                    sb.append(empty(pointer)).append("\n");
                    break;
                case "top":
                    sb.append(top(STACK, pointer)).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void push(int s, int[] stack, int pointer) {
        stack[pointer] = s;
    }

    private static int pop(int[] stack, int pointer) {
        if (pointer == -1){
            return -1;
        }
        int num = stack[pointer];
        stack[pointer] = 0;
        return num;
    }

    private static int size(int pointer) {
        return pointer + 1;
    }

    private static int empty(int pointer) {
        if (pointer == -1){
            return 1;
        }
        return 0;
    }

    private static int top(int[] stack, int pointer) {
        if (pointer == -1) {
            return -1;
        }
        return stack[pointer];
    }
}
