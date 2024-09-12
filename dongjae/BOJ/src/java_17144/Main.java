package java_17144;

import java.util.*;
import java.io.*;

class Node {
    private int x;
    private int y;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int r, c, t;
    public static int[][] map;
    public static List<Node> purifier = new ArrayList<>();
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    purifier.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < t; i++) {
            map = spread();
            clean();
        }

        int result = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result + 2);
    }

    public static int[][] spread() {
        int[][] tmpMap = new int[50][50];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) {
                    tmpMap[i][j] = -1;
                    continue;
                }
                tmpMap[i][j] += map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (map[nx][ny] != -1) {
                            tmpMap[nx][ny] += (map[i][j] / 5);
                            tmpMap[i][j] -= (map[i][j] / 5);
                        }
                    }
                }
            }
        }
        return tmpMap;
    }

    public static void clean() {
        Node top = purifier.get(0);

        for (int i = top.getX()-1; i > 0; i--) {
            map[i][0] = map[i-1][0];
        }

        for (int i = 0; i < c-1; i++) {
            map[0][i] = map[0][i+1];
        }

        for (int i = 0; i < top.getX(); i++) {
            map[i][c-1] = map[i+1][c-1];
        }

        for (int i = c-1; i > 1; i--) {
            map[top.getX()][i] = map[top.getX()][i-1];
        }

        map[top.getX()][1] = 0;

        Node btm = purifier.get(1);

        for (int i = btm.getX()+1; i < r-1; i++) {
            map[i][0] = map[i+1][0];
        }

        for (int i = 0; i < c-1; i++) {
            map[r-1][i] = map[r-1][i+1];
        }

        for (int i = r-1; i > btm.getX(); i--) {
            map[i][c-1] = map[i-1][c-1];
        }

        for (int i = c-1; i > 1; i--) {
            map[btm.getX()][i] = map[btm.getX()][i-1];
        }

        map[btm.getX()][1] = 0;
    }
}
