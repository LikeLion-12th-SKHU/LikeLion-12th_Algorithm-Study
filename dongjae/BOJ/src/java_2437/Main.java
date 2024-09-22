package java_2437;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + 1 < array[i]) break;
            sum += array[i];
        }

        System.out.println(sum + 1);
    }
}
