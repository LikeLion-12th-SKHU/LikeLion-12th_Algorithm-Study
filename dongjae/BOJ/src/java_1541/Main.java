package java_1541;

import java.util.*;
import java.io.*;

public class Main {
    public static List<String> plusArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while(st.hasMoreTokens()) {
            plusArr.add(st.nextToken());
        }

        int ans = calc(plusArr.get(0));

        if (plusArr.size() == 1) {
            System.out.println(ans);
        } else {
            for (int i = 1; i < plusArr.size(); i++) {
                ans -= calc(plusArr.get(i));
            }
            System.out.println(ans);
        }
    }

    public static int calc(String str) {
        StringTokenizer st = new StringTokenizer(str, "+");
        int result = 0;
        while (st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        return result;
    }
}
