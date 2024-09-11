package java_5576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] w = new int[10];
        int[] k = new int[10];

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            w[i] = n;
        }
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            k[i] = n;
        }
        sumScore(w);
        sumScore(k);
    }
    private static void sumScore(int[] n) {
        int sum = 0;
        Arrays.sort(n);

        for (int i = n.length-3; i < n.length; i++) {
            sum += n[i];
        }
        System.out.print(sum + " ");
    }
}