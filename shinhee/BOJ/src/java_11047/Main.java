package BOJ.src.java_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int[] coins = new int[N];

        for (int i = N - 1; i >= 0; i--){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i: coins){
            count += K / i;
            K %= i;
        }
        System.out.println(count);

    }
}
