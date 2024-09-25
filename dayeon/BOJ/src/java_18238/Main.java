package java_18238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;

        if (str.charAt(0) == 'Z') {
            sum += 1;
        } else {
            sum += count('A', str.charAt(0));
        }
        for (int i = 1; i <= str.length()-1; i++) {
            sum += count(str.charAt(i-1), str.charAt(i));
        }
        System.out.println(sum);
    }
    public static int count(char c1, char c2) {
        int n1 = c1 - 'A';
        int n2 = c2 - 'A';

        return Math.min(Math.abs(n1-n2), 26-(Math.abs(n1-n2)));
    }
}
