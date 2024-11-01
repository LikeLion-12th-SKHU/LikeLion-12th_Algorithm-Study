package java_2003;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static long m;
    public static int[] array;
    public static long[] sumArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        array = new int[n+1];
        sumArray = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            sumArray[i] = sumArray[i-1] + array[i];
        }

        System.out.println(count(m));
    }

    public static int count(long target) {
        int count = 0;
        int start = 1;
        int end = 1;

        while (end <= n) {
            long sum = sumArray[end] - sumArray[start-1];
            if (sum < target) {
                end++;
            } else if (sum == target) {
                count++;
                end++;
            } else {
                start++;
            }
        }

        return count;
    }
}
