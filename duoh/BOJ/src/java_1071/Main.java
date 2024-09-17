package java_1071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[SIZE + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[num]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
            if (A[i] == 0) {
                continue;
            }

            if (i < SIZE - 1 && A[i + 1] > 0) {
                int j = i + 2;

                while (j < SIZE && A[j] == 0) {
                    j++;
                }

                if (j < SIZE) {
                    while (A[i] > 0) {
                        sb.append(i).append(' ');
                        A[i]--;
                    }
                    sb.append(j).append(' ');
                    A[j]--;
                } else {
                    while (A[i + 1] > 0) {
                        sb.append(i + 1).append(' ');
                        A[i + 1]--;
                    }

                    while (A[i] > 0) {
                        sb.append(i).append(' ');
                        A[i]--;
                    }
                }
            } else {
                while (A[i] > 0) {
                    sb.append(i).append(' ');
                    A[i]--;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
