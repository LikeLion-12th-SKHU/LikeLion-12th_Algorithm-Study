package java_3425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final long LIMIT = 1_000_000_000L;
    private static List<String> commands;
    private static Deque<Long> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            commands = new ArrayList<>();

            while (true) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();

                if (cmd.equals("END")) break;
                if (cmd.equals("QUIT")) {
                    System.out.println(sb);
                    br.close();
                    return;
                }

                commands.add(cmd);
                if (cmd.equals("NUM")) {
                    commands.add(st.nextToken());
                }
            }

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                long value = Long.parseLong(br.readLine());
                sb.append(process(value) ? stack.peek() : "ERROR").append('\n');
            }

            sb.append('\n');
            br.readLine();
        }
    }

    private static boolean process(long value) {
        stack = new ArrayDeque<>();
        stack.push(value);

        for (int i = 0; i < commands.size(); i++) {
            String cmd = commands.get(i);

            if (cmd.equals("NUM")) {
                long num = Long.parseLong(commands.get(++i));
                stack.push(num);
                continue;
            }

            if (!checkSize(cmd)) return false;
            switch (cmd) {
                case "POP":
                    stack.pop();
                    break;
                case "INV":
                    stack.push(-stack.pop());
                    break;
                case "DUP":
                    stack.push(stack.peek());
                    break;
                case "SWP":
                    swap();
                    break;
                case "ADD":
                    if (!add()) return false;
                    break;
                case "SUB":
                    if (!sub()) return false;
                    break;
                case "MUL":
                    if (!mul()) return false;
                    break;
                case "DIV":
                    if (!div()) return false;
                    break;
                case "MOD":
                    if (!mod()) return false;
                    break;
                default:
                    return false;
            }
        }

        return stack.size() == 1;
    }

    private static boolean checkSize(String cmd) {
        if (cmd.equals("POP") || cmd.equals("INV") || cmd.equals("DUP")) {
            return !stack.isEmpty();
        } else {
            return stack.size() >= 2;
        }
    }

    private static void swap() {
        long first = stack.pop();
        long second = stack.pop();
        stack.push(first);
        stack.push(second);
    }

    private static boolean add() {
        long first = stack.pop();
        long second = stack.pop();
        if (Math.abs(first + second) > LIMIT) return false;
        stack.push(first + second);
        return true;
    }

    private static boolean sub() {
        long first = stack.pop();
        long second = stack.pop();
        if (Math.abs(second - first) > LIMIT) return false;
        stack.push(second - first);
        return true;
    }

    private static boolean mul() {
        long first = stack.pop();
        long second = stack.pop();
        if (Math.abs(first * second) > LIMIT) return false;
        stack.push(first * second);
        return true;
    }

    private static boolean div() {
        if (stack.peek() == 0) return false;
        long first = stack.pop();
        long second = stack.pop();
        stack.push(second / first);
        return true;
    }

    private static boolean mod() {
        if (stack.peek() == 0) return false;
        long first = stack.pop();
        long second = stack.pop();
        stack.push(second % first);
        return true;
    }
}
