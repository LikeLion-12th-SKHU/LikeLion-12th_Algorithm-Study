package java_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] strSplit = str.strip().split(" ");

        System.out.println(printLength(strSplit));
        bf.close();
    }

    static long printLength(String[] strSplit){
        if (strSplit[0].isEmpty()) {
            return strSplit.length - 1;
        }
        return strSplit.length;
    }
}
