package java_2143;

import java.util.*;
import java.io.*;

public class Main {
    public static long t;
    public static int n, m;
    public static int[] A, B;
    public static long[] sumArrayA, sumArrayB;
    public static List<Long> sumA = new ArrayList<>();
    public static List<Long> sumB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Long.parseLong(br.readLine());

        n = Integer.parseInt(br.readLine());
        A = new int[n+1];
        sumArrayA = new long[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sumArrayA[i] = sumArrayA[i-1] + A[i];
        }

        m = Integer.parseInt(br.readLine());
        B = new int[m+1];
        sumArrayB = new long[m+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            sumArrayB[i] = sumArrayB[i-1] + B[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                long now = sumArrayA[j] - sumArrayA[i-1];
                sumA.add(now);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                long now = sumArrayB[j] - sumArrayB[i-1];
                sumB.add(now);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        System.out.println(find(t));
    }

    public static long find(long target) {
        int start = 0;
        int end = sumB.size() - 1;
        long count = 0;

        while (start < sumA.size() && end >= 0) {
            long now = sumA.get(start) + sumB.get(end);
            if (now > target) {
                end--;
            } else if (now == target) {
                long aValue = sumA.get(start);
                long bValue = sumB.get(end);
                int aCount = 0;
                int bCount = 0;
                while (start < sumA.size() && sumA.get(start) == aValue) {
                    start++;
                    aCount++;
                }
                while (end >= 0 && sumB.get(end) == bValue) {
                    end--;
                    bCount++;
                }
                count += (long) aCount * bCount;
            } else {
                start++;
            }
        }

        return count;
    }
}