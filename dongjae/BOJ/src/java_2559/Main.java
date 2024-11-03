package java_2559;

import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] array;
    public static long[] sumArray;
    public static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n+1];
        sumArray = new long[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            sumArray[i] = sumArray[i-1] + array[i];
        }

        findMax();

        System.out.println(max);
    }

    public static void findMax() {
        int start = 1;
        int end = k;

        while (end <= n) {
            long now = sumArray[end] - sumArray[start-1];
            max = Math.max(now, max);
            start++;
            end++;
        }
    }
}
