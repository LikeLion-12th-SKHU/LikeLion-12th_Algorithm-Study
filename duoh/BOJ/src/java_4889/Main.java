package java_4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int testCase = 1;

        while (true) {
            char[] ch = br.readLine().toCharArray();

            if (ch[0] == '-') {
                break;
            }

            int openCnt = 0, fixCnt = 0;

            for (char c : ch) {
                if (c == '{') {
                    openCnt++;
                } else {
                    if (openCnt > 0) {
                        openCnt--;
                    } else {
                        fixCnt++;
                        openCnt++;
                    }
                }
            }

            fixCnt += openCnt / 2;
            sb.append(testCase).append(". ")
                    .append(fixCnt).append('\n');
            testCase++;
        }

        System.out.println(sb);
        br.close();
    }
}
