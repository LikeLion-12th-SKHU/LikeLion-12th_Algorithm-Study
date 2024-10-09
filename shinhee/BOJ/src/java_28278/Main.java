package BOJ.src.java_28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);

            switch(st.nextToken()) {
                case "1" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "2" :
                    if(stack.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(stack.pop()).append('\n');
                    break;
                case "3" :
                    sb.append(stack.size()).append('\n');
                    break;
                case "4" :
                    if(stack.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                case "5" :
                    if(stack.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(stack.peek()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}
