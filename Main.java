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
        char uppercaseSymbol = Character.toUpperCase(symbol);

        switch (uppercaseSymbol) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
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
