package cover;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {

        String s = "2 0\n" +
                "\n" +
                "   1      0 1\n" +
                "\n" +
                "0 -3\n" +
                "1\n" +
                "0\n" +
                "2 3 2 0\n" +
                "-3 3\n" +
                "-3 2\n" +
                "-3 1\n" +
                "4 -1 -5 1000000000 0\n" +
                "2 -2 0\n" +
                "-6 3\n" +
                "-6 2\n" +
                "-6 1\n" +
                "1 6 0\n" +
                "-6 3\n" +
                "-6 2\n" +
                "-6 1";

        Scanner scanner = new Scanner(s);
        Main.processInputData(scanner, null);
    }
}
