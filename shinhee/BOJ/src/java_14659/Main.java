package BOJ.src.java_14659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] hunters = new int[N];
        for (int i = 0; i < N; i++) {
            hunters[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        // 각 원소 기준으로 원소보다 작은 값들(다음에 오는 값) 세기
        for (int i = 0; i < N; i++) {
            int kill = 0;
            for (int j = i + 1; j < N; j++) {
                if (hunters[i] > hunters[j]) {
                    kill++;
                } else {
                    break;
                }
            }
            result[i] = kill;
        }

        // 그 값들 중 가장 큰 값 출력
        int max = 0;
        for (int i : result) {
            if (max < i){
                max = i;
            }
        }
        System.out.println(max);
    }
}