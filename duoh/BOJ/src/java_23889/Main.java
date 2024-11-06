package java_23889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 누적합 배열
        st = new StringTokenizer(br.readLine());
        int[] X = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            X[i] = X[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 돌 위치
        st = new StringTokenizer(br.readLine());
        int[] S = new int[K];
        for (int i = 0; i < K; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 파괴된 모래성
        int[][] arr = new int[K][2];
        for (int i = 0; i < K - 1; i++) {
            arr[i] = new int[]{X[S[i + 1] - 1] - X[S[i] - 1], S[i]};
        }
        arr[K - 1] = new int[] {X[N] - X[S[K - 1] - 1], S[K - 1]};

        // 파괴량 내림차순 정렬
        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);

        // 상위 M개의 위치, 오름차순 정렬
        int[] W = new int[M];
        for (int i = 0; i < M; i++) {
            W[i] = arr[i][1];
        }
        Arrays.sort(W);

        StringBuilder sb = new StringBuilder();
        for (int w : W) {
            sb.append(w).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
