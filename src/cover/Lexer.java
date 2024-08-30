package cover;

import java.util.Scanner;
import java.util.Stack;

public class Lexer {

    private Scanner scanner;
    private Stack<Integer> buffer = new Stack<>();

    public Lexer(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean hasNextInt() {
        return scanner.hasNext() || !buffer.empty();
    }

    public int nextInt() {
        if (!buffer.empty()) {
            return buffer.pop();
        } else {
            return scanner.nextInt();
        }
    }

    public void pushToBuffer(int number) {
        buffer.add(number);
    }

    public boolean isNextComponent() {
        if (hasNextInt()) {
            int next = nextInt();
            pushToBuffer(next);
            return next >= 0;
        }
        return false;
    }

    public boolean isNextQuery() {
        if (hasNextInt()) {
            int next = nextInt();
            pushToBuffer(next);
            return next < 0;
        }
        return false;
    }

    public boolean isComponentAnElement() {
        int skipFirst = nextInt();
        if (hasNextInt()) {
            int next = nextInt();
            pushToBuffer(next);
            pushToBuffer(skipFirst);
            return next >= 0;
        }
        pushToBuffer(skipFirst);
        return false;
    }

    public boolean isComponentFinite() {
        int skipFirst = nextInt();
        if (hasNextInt()) {
            int next1 = nextInt();
            if ((next1 < 0) && (hasNextInt())) {
                int next2 = nextInt();
                pushToBuffer(next2);
                pushToBuffer(next1);
                pushToBuffer(skipFirst);
                return next2 < 0;
            }
            pushToBuffer(next1);
        }
        pushToBuffer(skipFirst);
        return false;
    }

    public boolean isComponentInfinite() {
        int skipFirst = nextInt();
        if (hasNextInt()) {
            int next1 = nextInt();
            if ((next1 < 0) && (hasNextInt())) {
                int next2 = nextInt();
                pushToBuffer(next2);
                pushToBuffer(next1);
                pushToBuffer(skipFirst);
                return next2 >= 0;
            }
            pushToBuffer(next1);
        }
        pushToBuffer(skipFirst);
        return false;
    }

    public boolean isEndOfSet() {
        if (hasNextInt()) {
            int next = nextInt();
            pushToBuffer(next);
            return next == 0;
        }
        return false;
    }
}
