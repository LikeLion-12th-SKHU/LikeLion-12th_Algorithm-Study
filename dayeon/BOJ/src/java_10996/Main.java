package java_10996;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
    private static void print(int n) {
        for (int i = 0; i < n*2; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            else {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
    }
}
