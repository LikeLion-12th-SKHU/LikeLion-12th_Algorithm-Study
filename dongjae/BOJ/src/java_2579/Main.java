package java_2579;

import java.io.*;

public class Main {
    public static int n;
    public static int[] array = new int[301];
    public static long[] d = new long[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        d[0] = array[0];
        d[1] = array[0] + array[1];
        d[2] = Math.max(array[0], array[1]) + array[2];

        for (int i = 3; i < n; i++) {
            d[i] = Math.max(d[i-2], d[i-3] + array[i-1]) + array[i];
        }

        System.out.println(d[n-1]);
    }
}
