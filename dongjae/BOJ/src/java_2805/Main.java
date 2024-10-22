package java_2805;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static long m;
    public static long[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        array = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(binarySearch(m, 0, 1000000000));
    }

    public static long binarySearch(long target, long start, long end) {
        if (start > end) {
            return start - 1;
        }
        long mid = (start + end) / 2;
        long now = cut(mid);
        if (now >= target) {
            return binarySearch(target, mid + 1, end);
        } else {
            return binarySearch(target, start, mid - 1);
        }
    }

    public static long cut(long height) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] > height) {
                result += (array[i] - height);
            }
        }
        return result;
    }
}
