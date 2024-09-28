package BOJ.src.java_4796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        int L, P, V, share, rest;

        List<Integer> lists = new ArrayList<>();

        int count = 0;
        while (true) {
            str = br.readLine().split(" ");
            L = Integer.parseInt(str[0]);
            if (L == 0) {
                break;
            }
            P = Integer.parseInt(str[1]);
            V = Integer.parseInt(str[2]);
            count++;

            share = V / P;
            rest = V % P;

            lists.add((share * L) + Math.min(L, rest));
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Case " + (i + 1) + ": " + lists.get(i));
        }
    }
}
