package java_25556;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] stack = {0, 0, 0, 0};
        for (int i = 0; i < N;) {

            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (stack[j] < A[i]) {
                    stack[j] = A[i];
                    i++;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        br.close();
    }
}
