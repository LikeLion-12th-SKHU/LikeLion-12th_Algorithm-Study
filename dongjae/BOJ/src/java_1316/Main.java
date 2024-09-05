package java_1316;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        result = 0;

        for (int i = 0; i < n ; i++) {
            String str = br.readLine();
            char[] charArray = str.toCharArray();

            boolean check = true;

            Set<Character> set = new HashSet<>();
            set.add(charArray[0]);

            for (int j = 1; j < str.length(); j++) {
                if (set.contains(charArray[j]) && (charArray[j] != charArray[j-1])) {
                    check = false;
                    break;
                }
                set.add(charArray[j]);
            }

            if (check) result++;
        }

        System.out.println(result);
    }
}