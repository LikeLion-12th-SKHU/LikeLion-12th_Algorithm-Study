package java_10816;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (!map.containsKey(now)) {
                map.put(now, 1);
            } else {
                map.put(now, map.get(now)+1);
            }
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (!map.containsKey(key)) {
                sb.append("0").append(" ");
            } else {
                sb.append(map.get(key)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
