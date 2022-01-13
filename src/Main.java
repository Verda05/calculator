import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


            Scanner s = new Scanner(System.in);
            Num calc;

            System.out.println("Введите значение операции от 1 до 10, либо от I до X: ");
            System.out.println("Ввод осуществляется через пробел: ");

            String input = s.nextLine();
            String[] arr = input.split(" ");
            if (arr.length != 3) throw new IllegalArgumentException("Превышение допустимого колличества символов.");


            try {

                if (Integer.parseInt(arr[0]) > 10 || Integer.parseInt(arr[2]) > 10 ||
                        Integer.parseInt(arr[0]) < 0 || Integer.parseInt(arr[2]) <0  )
                    throw new IllegalArgumentException("Введите цифры от 1 до 10");
                calc = new Num(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]));

            } catch (NumberFormatException e) {
                int j = 1;
                boolean firstRomanFound = false;
                boolean secondRomanFound = false;

                while (j < 11 && (!firstRomanFound || !secondRomanFound)) {
                    if (arr[0].equals(RomNum.getRoman()[j])) {
                        firstRomanFound = true;
                    }
                    if (arr[2].equals(RomNum.getRoman()[j])) {
                        secondRomanFound = true;
                    }
                    j++;
                }

                if (firstRomanFound && secondRomanFound) {
                    calc = new RomNum(arr[0], arr[2]);
                } else throw new NumberFormatException("Цифры введены неверно");
            }


            switch (arr[1]) {
                case "+" -> calc.plus();
                case "-" -> calc.minus();
                case "*" -> calc.times();
                case "/" -> calc.div();
                default -> throw new IllegalArgumentException("Оператор введён неверно");
            }


            if (calc instanceof RomNum) {
                ((RomNum) calc).toRoman();
                System.out.println("Результат равен: " + ((RomNum) calc).getStringResult());
            } else System.out.println("Результат равен: " + calc.getResult());
    }
}