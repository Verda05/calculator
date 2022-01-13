public class RomNum extends Num {

    private String romanResult;

    private final static String[] LARGEROMAN = {"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
    private final static String[] ROMAN = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};

    public static String[] getRoman() {
        return ROMAN;
    }

    public RomNum(String firstRoman, String secondRoman) {
        super(toInt(firstRoman),toInt(secondRoman));
    }

    public String getStringResult() {
        return romanResult;
    }

    private static int toInt(String roman) {
        int i = 0;
        while (!roman.equals(ROMAN[i])) {
            i++;
        }
        return i;
    }

    public void toRoman() {

        if (result == 100) {
            romanResult = "C";
            return;
        }

        if (result < 1) {
            throw new RuntimeException("Значение римских цифр должно быть положительным");
        }

        int units = result % 10;
        int large = (result - units) / 10;

        String romanUnits = ROMAN[units];
        String romanLarge = LARGEROMAN[large];

        if (large == 0) {
            romanResult = romanUnits;
            return;
        }
        if (units == 0) {
            romanResult = romanLarge;
            return;
        }
        romanResult = romanLarge + romanUnits;
    }
}