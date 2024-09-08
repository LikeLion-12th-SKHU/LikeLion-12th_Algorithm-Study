package java_14891;

import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map = new int[4][8];
    public static int[] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                map[i][j] = charArray[j] - '0';
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            directions = new int[4];
            directions[idx] = dir;
            check(idx);
            turn();
        }

        int result = 0;
        if (map[0][0] == 1) result += 1;
        if (map[1][0] == 1) result += 2;
        if (map[2][0] == 1) result += 4;
        if (map[3][0] == 1) result += 8;

        System.out.println(result);
    }

    private static void check(int idx) {
        for (int i = idx-1; i >= 0; i--) {
            if (map[i][2] != map[i+1][6]) {
                directions[i] = -directions[i+1];
            } else {
                break;
            }
        }

        for (int i = idx+1; i < 4; i++) {
            if (map[i][6] != map[i-1][2]) {
                directions[i] = -directions[i-1];
            } else {
                break;
            }
        }
    }

    private static void turn() {
        int tmp = 0;

        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) {
                tmp = map[i][7];
                for (int j = 7; j > 0; j--) {
                    map[i][j] = map[i][j-1];
                }
                map[i][0] = tmp;
            }
            if (directions[i] == -1) {
                tmp = map[i][0];
                for (int j = 0; j < 7; j++) {
                    map[i][j] = map[i][j+1];
                }
                map[i][7] = tmp;
            }
        }
    }
}
