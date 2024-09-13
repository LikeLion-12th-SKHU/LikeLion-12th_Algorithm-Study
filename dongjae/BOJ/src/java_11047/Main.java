package java_11047;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, target;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            if (target - array[i] < 0) {
                continue;
            }
            count += (target / array[i]);
            target = target % array[i];
        }

        System.out.println(count);
    }
}
