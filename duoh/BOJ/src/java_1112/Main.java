package java_1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(convert(x, b));
        br.close();
    }

    private static String convert(int x, int b) {
        if (x == 0) {
            return "0";
        }

        boolean flag = (x < 0 && b > 1);
        if (flag) {
            x = -x;
        }

        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            int remainder = x % b;
            x /= b;

            if (remainder < 0) {
                remainder += Math.abs(b);
                x += 1;
            }
            sb.append(remainder);
        }

        if (flag) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }
}
