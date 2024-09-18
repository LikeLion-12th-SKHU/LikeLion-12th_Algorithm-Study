package java_2864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 0, max = 0;

        String n = st.nextToken();
        String m = st.nextToken();

        for (int i = 0; i < m.length(); i++) {
            if (n.charAt(i) == '6' || m.charAt(i) == '6') {
                n = n.replace('6', '5');
                m = m.replace('6', '5');
            }
            min = Integer.parseInt(n)+Integer.parseInt(m);
        }
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '5' || m.charAt(i) == '5') {
                n = n.replace('5', '6');
                m = m.replace('5', '6');
            }
            max = Integer.parseInt(n)+Integer.parseInt(m);
        }
        System.out.println(min + " " + max);
    }
}