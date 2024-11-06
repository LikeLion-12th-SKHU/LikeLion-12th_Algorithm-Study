package BOJ.src.java_2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        number = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= N - K; i++){
            int sum = 0;
            for(int j = i; j < i + K; j++){
                sum += number[j];
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
