package converter;

import java.util.HashMap;

public class Main implements Convert {

    HashMap<Character, Integer> symbols = new HashMap<>();

    void addToMap() {
        symbols.put('m', 1000);
        symbols.put('d', 500);
        symbols.put('c', 100);
        symbols.put('l', 50);
        symbols.put('x', 10);
        symbols.put('v', 5);
        symbols.put('i', 1);
    }

    private final char[] keyRoman = {'m', 'd', 'c', 'l', 'x', 'v', 'i'};
    private final short[] keyNumbers = {1000, 500, 100, 50, 10, 5, 1};

    /**
     * Takes a number and converts it to roman number.
     * @param number the number to convert
     * @return String
     */
    @Override
    public String encode(int number) {
        String finalString = "";

        for (var i = 0; i < keyNumbers.length; i++) {
            var temp = number / keyNumbers[i];
            var quotient = temp * keyNumbers[i];
            number -= quotient;

            for (var j = 0; j < temp; j++) {

                finalString += keyRoman[i];
            }
        }

        return finalString;
    }

    /**
     * Takes in a roman number and converts to number
     * @param romanNumber the string to convert to numbers
     * @return 
     */
    @Override
    public int decode(String romanNumber) {
        int intNum = 0;
        int prev = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int temp = symbols.get(romanNumber.charAt(i));

            if (temp < prev) {
                intNum -= temp;
            } else {
                intNum += temp;
            }

            prev = temp;
        }
        return intNum;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.addToMap();
        System.out.println(main.encode(2515));
        System.out.println(main.decode("mmdxv"));
    }

}
