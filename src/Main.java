
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        calc();
    }

    private static int calculate(String operator, int num1, int num2) {
       int sum = 0;
        switch (operator) {
            case "+":
                sum = num1 + num2;
                break;
            case "-":
                sum = num1 - num2;
                break;
            case "*":
                sum = num1 * num2;
                break;
            case "/":
                sum = num1 / num2;
                break;
            default:
                throw new RuntimeException("wrong");
        }
        return sum;

    }


    private static int convertRomanToArabic(String romNum) {
        int arabicNum = 0;
        if (romNum.equals("I")) {
            arabicNum = 1;
        } else if (romNum.equals("II")) {
            arabicNum = 2;
        } else if (romNum.equals("III")) {
            arabicNum = 3;
        } else if (romNum.equals("IV")) {
            arabicNum = 4;
        } else if (romNum.equals("V")) {
            arabicNum = 5;
        } else if (romNum.equals("VI")) {
            arabicNum = 6;
        } else if (romNum.equals("VII")) {
            arabicNum = 7;
        } else if (romNum.equals("VIII")) {
            arabicNum = 8;
        } else if (romNum.equals("IX")) {
            arabicNum = 9;
        } else if (romNum.equals("X")) {
            arabicNum = 10;
        } else {
            throw new RuntimeException("Wrong Roman");
        }
        return arabicNum;
    }

    private static void calc() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Calc input");
        String inputString = reader.readLine();
        String[] sArray = inputString.split(" ");
        String arabicNumbers = "12345678910";
        String romanNumbers = "I II III IV V VI VII VIII IX X";
        String operations = "+-*/";

        if (sArray.length != 3) {
            throw new RuntimeException("Wrong Length");
        }
        if (!operations.contains(sArray[1])) {
            throw new RuntimeException("Wrong Operators");
        }

        if (arabicNumbers.contains(sArray[0]) && arabicNumbers.contains(sArray[2])) {
            arabicInputData(sArray);
        } else if (romanNumbers.contains(sArray[0]) && romanNumbers.contains(sArray[2])) {
            romanInputData(sArray);
        } else {
            throw new RuntimeException("Wrong InputData");
        }
    }

    private static void romanInputData(String[] sArray) throws IOException {


        int arabicNumb1 = convertRomanToArabic(sArray[0]);
        int arabicNumb2 = convertRomanToArabic(sArray[2]);

        int sum = calculate(sArray[1], arabicNumb1, arabicNumb2);

        if (sum <= 0) {
            throw new RuntimeException("Negative Roman");
        }
        integerToRomanNumeral(sum);

        String romanSum = integerToRomanNumeral(sum);

        System.out.println(romanSum);
    }

    private static void arabicInputData(String[] sArray) throws IOException {

        int num1 = Integer.parseInt(sArray[0]);
        if (num1 < 1 || num1 > 10) {
            throw new RuntimeException("Wrong Roman");
        }
        int num2 = Integer.parseInt(sArray[2]);
        if (num2 < 1 || num2 > 10) {
            throw new RuntimeException("Wrong Roman");
        }
        int sum = calculate(sArray[1], num1, num2);
        System.out.println(sum);

    }

    public static String integerToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;
        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }

}





