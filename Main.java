import java.util.Scanner;

class Main {
    public static int romanToInt(String s) {
        int total = 0;
        int greatestSymbolValue = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            if (greatestSymbolValue < symbolToInt(s.charAt(i))) {
                total += symbolToInt(s.charAt(i));
                greatestSymbolValue = symbolToInt(s.charAt(i));
            }
            else if (greatestSymbolValue == symbolToInt(s.charAt(i))) {
                total += symbolToInt(s.charAt(i));
            }
            else {
                total -= symbolToInt(s.charAt(i));
            }
        }
        return total;
    }

    private static int symbolToInt(char symbol) {
        if (symbol == 'I') {
            return 1;
        }
        else if (symbol == 'V') {
            return 5;
        }
        else if (symbol == 'X') {
            return 10;
        }
        else if (symbol == 'L') {
            return 50;
        }
        else if (symbol == 'C') {
            return 100;
        }
        else if (symbol == 'D') {
            return 500;
        }
        else if (symbol == 'M') {
            return 1000;
        }
        else {
            throw new IllegalArgumentException("Symbol " + symbol + " not recognised. Symbols must be either I, V, X, L, C, D, or M.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a Roman Numeral: ");
            String romanNumeral = scanner.nextLine();

            try {
                System.out.println("The value of " + romanNumeral + " is " + romanToInt(romanNumeral));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
