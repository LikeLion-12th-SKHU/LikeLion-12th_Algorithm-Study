package java_22864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 피로도
public class Main {
    public static int Time = 24;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 피로도(+)
        int b = Integer.parseInt(st.nextToken()); // 일 진행도(+)
        int c = Integer.parseInt(st.nextToken()); // 피로도(-)
        int m = Integer.parseInt(st.nextToken()); // 최대 피로도
        int n = 0; // 현재 피로도
        int work = 0; // 현재 일 진행도

        for (int i = 0; i < Time; i++) {
            if (n + a <= m) { // 일 진행 후 피로도가 최대 피로도보다 작거나 같다면
                n += a;
                work += b; // 일 진행
            } else { // 일 진행 후 피로도가 최대 피로도를 넘어가면
                n -= c; // 쉬기
                if (n < 0) n = 0; // 피로도가 0 이하로 내려가도 0
            }
        }
        System.out.println(work);
    }
}