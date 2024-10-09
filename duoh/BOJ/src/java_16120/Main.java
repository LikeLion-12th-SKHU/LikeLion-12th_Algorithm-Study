package java_16120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        int countP = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'P') {
                countP++;
            } else {
                if (countP >= 2 && i + 1 < ch.length && ch[i + 1] == 'P') {
                    countP -= 2;
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }

        System.out.println(countP == 1 ? "PPAP" : "NP");
        br.close();
    }
}
