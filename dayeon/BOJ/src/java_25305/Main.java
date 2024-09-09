package java_25305;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        int[] y = new int[n];
        y = BubbleSort(x, n);

        System.out.println(x[n - k]);
    }
    private static int[] BubbleSort(int[] x, int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (x[j] > x[j+1]) {
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }
        return x;
    }
}
