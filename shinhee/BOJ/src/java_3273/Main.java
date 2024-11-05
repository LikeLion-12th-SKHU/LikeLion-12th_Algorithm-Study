package BOJ.src.java_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        System.out.println(count(N, arr, X));
    }

    public static int count(int N, int[] arr, int X) {
        int left = 0;
        int right = N - 1;
        int count = 0;
        int sum = 0;

        Arrays.sort(arr);

        while(left < right) {
            sum = arr[right] + arr[left];

            if(sum == X) count++;

            if(sum < X) {
                left++;
            }else {
                right--;
            }
        }
        return count;
    }
}
