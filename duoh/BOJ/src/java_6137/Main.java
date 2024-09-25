package java_6137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int LINE = 80;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] S = new char[N];
        for (int i = 0; i < N; i++) {
            S[i] = br.readLine().charAt(0);
        }

        int count = 0, left = 0, right = N - 1;
        StringBuilder sb = new StringBuilder();

        while (left <= right) {
            boolean flag = false;

            if (S[left] == S[right]) {
                int l = left + 1, r = right - 1;

                while (l <= r) {
                    if (S[l] < S[r]) {
                        flag = true;
                        break;
                    } else if (S[l] > S[r]) {
                        break;
                    }
                    l++; r--;
                }
            } else {
                flag = S[left] < S[right];
            }

            if (flag) {
                sb.append(S[left]);
                left++;
            } else {
                sb.append(S[right]);
                right--;
            }
            count++;

            if (count % LINE == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
