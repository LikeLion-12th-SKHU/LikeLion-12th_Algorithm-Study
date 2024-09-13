package java_5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        count(1000 - n);
        br.close();
    }
    private static void count(int n) {
        int sum = 0;
        sum += n / 500; n %= 500; // 500엔
        sum += n / 100; n %= 100; // 100엔
        sum += n / 50; n %= 50; // 50엔
        sum += n / 10; n %= 10; // 10엔
        sum += n / 5; n %= 5; // 5엔
        sum += n; // 1엔

        System.out.print(sum);
    }
}