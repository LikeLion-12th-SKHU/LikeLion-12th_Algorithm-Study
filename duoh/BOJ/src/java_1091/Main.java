package java_1091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, cnt = 0;
    private static int[] P, S, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = i % 3;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        copy = origin.clone();
        while (!isMatch()) {
            shuffle();
            if (Arrays.equals(origin, copy)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static boolean isMatch() {
        for (int i = 0; i < N; i++) {
            if (copy[i] != P[i]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle() {
        int[] tmp = new int[N];
        for (int i = 0; i < N; i++) {
            tmp[i] = copy[S[i]];
        }
        copy = tmp.clone();
        cnt++;
    }
}
