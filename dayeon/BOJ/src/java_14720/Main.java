package java_14720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 우유 축제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] shops = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            shops[i] = num;
        }

        int type = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(shops[i] == type) {
                count++;
                type = (type + 1) % 3;
            }
        }
        System.out.println(count);
        br.close();
    }
}
