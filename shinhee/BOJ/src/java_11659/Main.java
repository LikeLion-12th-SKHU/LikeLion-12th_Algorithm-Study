package BOJ.src.java_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[] arr = new int[N + 1];

        arr[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int j = 1; j <= N; j++){
            sum = sum +Integer.parseInt(st.nextToken());
            arr[j] = sum;
        }

        for(int q = 0; q < M; q++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(arr[j] - arr[i-1]);
        }
    }
}
