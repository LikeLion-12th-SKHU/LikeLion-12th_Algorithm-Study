package java_23889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] X = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            X[i] = X[i - 1] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[N + 1];
        for (int i = 0; i < K; i++) {
            int S = Integer.parseInt(st.nextToken());
            check[S] = true;
        }

        List<long[]> V = new ArrayList<>();
        long sum = 0;
        for (int i = N; i >= 1; i--) {
            sum += X[i];
            if (check[i]) {
                V.add(new long[]{sum, i});
                sum = 0;
            }
        }

        V.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            }
            return Long.compare(o2[0], o1[0]);
        });

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(M, V.size()); i++) {
            ans.add((int) V.get(i)[1]);
        }

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int x : ans) {
            sb.append(x).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
