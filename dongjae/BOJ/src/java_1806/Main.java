package java_1806;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static long s;
    public static int[] array;
    public static long[] sumArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Long.parseLong(st.nextToken());

        array = new int[n+1];
        sumArray = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        sumArray[0] = array[0];
        for (int i = 1; i <= n; i++) {
            sumArray[i] = sumArray[i-1] + array[i];
        }

        System.out.println(find());
    }

    public static int find() {
        int start = 1;
        int end = 1;
        int min = Integer.MAX_VALUE;
        while (end <= n && start <= end) {
            long sum = sumArray[end] - sumArray[start - 1];
            if (sum < s) {
                end++;
            } else {
                min = Math.min(min, end - start + 1);
                start++;
            }
        }
        if (min == Integer.MAX_VALUE) return 0;
        else return min;
    }
}