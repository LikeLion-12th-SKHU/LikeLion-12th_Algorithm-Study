package java_8989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<String> pq = new PriorityQueue<>(
                    Comparator.comparingDouble((String time) -> {
                        String[] hhmm = time.split(":");
                        int hh = Integer.parseInt(hhmm[0]);
                        int mm = Integer.parseInt(hhmm[1]);
                        return calculateAngle(hh, mm);
                    }).thenComparing(time -> time)
            );

            for (int j = 0; j < SIZE; j++) {
                pq.offer(st.nextToken());
            }

            pq.poll();
            pq.poll();
            sb.append(pq.poll()).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static double calculateAngle(int hh, int mm) {
        double hhAngle = (hh % 12) * 30 + (mm * 0.5);
        double mmAngle = mm * 6;
        double angle = Math.abs(hhAngle - mmAngle);
        return Math.min(angle, 360 - angle);
    }
}
