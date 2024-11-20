package BOJ.src.java_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, num[], result[];
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);

        backtracking(0, 0);
        System.out.println(str);
    }

    public static void backtracking(int cnt, int start) {
        if(cnt == M) {
            for (int num : result)
                str.append(num).append(" ");
            str.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            result[cnt] = num[i];
            backtracking(cnt+1, i+1);
        }
    }
}
