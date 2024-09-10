package java_6359;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cases = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            cases[i] = num;
        }
        for (int i = 0; i < n; i++) {
            startGame(cases[i]);
        }
    }
    private static void startGame(int n) {
        boolean[] rooms = new boolean[n+1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                rooms[j] = !rooms[j];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (rooms[i]) count++;
        }
        System.out.println(count);
    }
}
