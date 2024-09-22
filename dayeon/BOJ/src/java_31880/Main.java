package java_31880;

import java.util.Scanner;

// K512컵 개최!
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long luck = 0, num = 0;

        for (int i = 0; i < n; i++) {
            luck += sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            num = sc.nextInt();
            if (num != 0) { luck *= num; }
        }
        System.out.println(luck);
        sc.close();
    }
}
