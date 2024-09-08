package java_25305;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 응시자 수
        int k = sc.nextInt(); // 상 받는 사람 수

        int[] x = new int[n]; // 각 학생 점수
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (x[j] > x[j+1]) {
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }
        System.out.println(x[n - k]);
    }
}
