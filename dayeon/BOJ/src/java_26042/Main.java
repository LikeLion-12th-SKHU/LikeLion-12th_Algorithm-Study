package java_26042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int last = 0;
        Queue<Integer> line = new LinkedList<>(); // 현재 대기 줄

        // n번 정보까지 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(st.nextToken())) { // 유형에 따라 처리
                case 1: // 1유형 : 학생이 대기 줄을 섬
                    int student = Integer.parseInt(st.nextToken());
                    line.add(student);
                    // 1유형 중 학생 수가 최대일 때를 저장
                    if (max < line.size()) {
                        max = line.size();
                        last = student;
                    } else if (max == line.size()) {
                        last = Math.min(last, student);
                    }
                    break;
                case 2: // 2유형 : 앞쪽 학생이 식사함
                    line.poll();
                    break;
                default:
                    break;
            }
        }
        System.out.println(max + " " + last);
    }
}