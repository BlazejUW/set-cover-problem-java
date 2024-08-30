package cover;

import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        processInputData(scanner, System.out);
    }

    public static void processInputData(Scanner scanner, PrintStream out) {
        List<MySet> setFamily = new ArrayList<>();
        Lexer lexer = new Lexer(scanner);

        while (lexer.hasNextInt()) {
            if (lexer.isNextComponent()) {
                Set<Component> setComponents = new HashSet<>();
                while (!lexer.isEndOfSet()) {
                    // Element
                    if (lexer.isComponentAnElement()) {
                        Element newElement = new Element(lexer.nextInt());
                        setComponents.add(newElement);
                    }
                    // Infinite
                    else if (lexer.isComponentInfinite()) {
                        int start = lexer.nextInt();
                        int step = -lexer.nextInt();
                        setComponents.add(new Infinite(start, step));
                    }
                    // Finite
                    else if (lexer.isComponentFinite()) {
                        int start = lexer.nextInt();
                        int step = -lexer.nextInt();
                        int end = -lexer.nextInt();
                        setComponents.add(new Finite(start, step, end));
                    }
                }
                lexer.nextInt(); // consume the ending zero
                MySet newSet = new MySet(setComponents);
                setFamily.add(newSet);
            }
            else if (lexer.isNextQuery()) {
                SetToCover setToCover = new SetToCover(-lexer.nextInt());
                int algorithmNumber = lexer.nextInt();
                Query query = new Query(setToCover, algorithmNumber);

                printSetCover(query.findSetCover(setFamily), out);
            }
        }
    }

    private static void printSetCover(List<Integer> cover, PrintStream out) {

        for (int i = 0; i < cover.size(); i++) {
            out.print(cover.get(i));
            if (i == cover.size() - 1) {
                out.print("\n");
            }
            else {
                out.print(" ");
            }
        }
    }
}
