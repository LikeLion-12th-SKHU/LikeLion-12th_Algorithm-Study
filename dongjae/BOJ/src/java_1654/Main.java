package java_1654;

import java.util.*;
import java.io.*;

public class Main {
    public static int k, n;
    public static long[] array;
    public static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        array = new long[k];
        for (int i = 0; i < k; i++) {
            array[i] = Long.parseLong(br.readLine());
            max = Math.max(max, array[i]);
        }

        System.out.println(binarySearch(1, max));
    }

    public static long binarySearch(long start, long end) {
        if (start > end) {
            return end;
        }
        long mid = (start + end) / 2;
        if (cut(mid) >= n) {
            return binarySearch(mid + 1, end);
        } else {
            return binarySearch(start, mid - 1);
        }
    }

    public static long cut(long length) {
        long count = 0;
        for (int i = 0; i < k; i++) {
            count += (array[i] / length);
        }
        return count;
    }
}