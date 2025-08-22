/**
    Arquitetura de Computadores I - Guia_02.java 
    845963 - Kayky Gabriel Marques 
*/
import java.util.Scanner;

public class Guia_02 {
    private static int errors = 0; // Contador de erros

    // Testar se dois valores sao iguais
    public static void test_equals(Object x, Object y) {
        if (x instanceof Double && y instanceof Double) {
            if (Math.abs((Double) x - (Double) y) > 0.0000001) {
                errors++;
            }
        } else {
            if (!x.toString().equals(y.toString())) {
                errors++;
            }
        }
    }

    // Exibir total de erros
    public static String test_report() {
        return "" + errors;
    }

    // Converter valor binário para decimal (com fração)
    public static double bin2double(String value) {
        int dotIndex = value.indexOf('.');

        if (dotIndex == -1) { // sem parte fracionária
            return Integer.parseInt(value, 2);
        }

        String integerPart = value.substring(0, dotIndex);
        String fractionalPart = value.substring(dotIndex + 1);

        double result = 0.0;

        // Parte inteira
        for (int i = 0; i < integerPart.length(); i++) {
            if (integerPart.charAt(i) == '1') {
                int power = integerPart.length() - 1 - i;
                result += Math.pow(2, power);
            }
        }

        // Parte fracionária
        for (int i = 0; i < fractionalPart.length(); i++) {
            if (fractionalPart.charAt(i) == '1') {
                result += Math.pow(2, -(i + 1));
            }
        }
        return result;
    }

    // Converter decimal (double) para binário
    public static String double2bin(double value) {
        int integerPart = (int) value;
        double fractionalPart = value - integerPart;

        String integerBinary = Integer.toBinaryString(integerPart);

        if (fractionalPart == 0) {
            return integerBinary;
        }

        StringBuilder fractionalBinary = new StringBuilder();
        int maxPrecision = 32;

        while (fractionalPart > 0 && maxPrecision > 0) {
            fractionalPart *= 2;
            if (fractionalPart >= 1) {
                fractionalBinary.append("1");
                fractionalPart -= 1;
            } else {
                fractionalBinary.append("0");
            }
            maxPrecision--;
        }

        return integerBinary + "." + fractionalBinary.toString();
    }

    // Converter binário fracionário para outra base
    public static String dbin2base(String value, int base) {
        int dotIndex = value.indexOf('.');
        String integerPartStr = (dotIndex != -1) ? value.substring(0, dotIndex) : value;
        String fractionalPartStr = (dotIndex != -1) ? value.substring(dotIndex + 1) : "";

        long decimalIntegerPart = Long.parseLong(integerPartStr, 2);

        double decimalFractionalPart = 0.0;
        for (int i = 0; i < fractionalPartStr.length(); i++) {
            if (fractionalPartStr.charAt(i) == '1') {
                decimalFractionalPart += Math.pow(2, -(i + 1));
            }
        }

        StringBuilder baseIntegerPart = new StringBuilder();
        if (decimalIntegerPart == 0) {
            baseIntegerPart.append("0");
        } else {
            while (decimalIntegerPart > 0) {
                long remainder = decimalIntegerPart % base;
                baseIntegerPart.insert(0, Character.forDigit((int) remainder, base));
                decimalIntegerPart /= base;
            }
        }

        StringBuilder baseFractionalPart = new StringBuilder();
        int maxPrecision = 10;
        while (decimalFractionalPart > 0 && baseFractionalPart.length() < maxPrecision) {
            decimalFractionalPart *= base;
            int digit = (int) decimalFractionalPart;
            baseFractionalPart.append(Character.forDigit(digit, base));
            decimalFractionalPart -= digit;
        }

        return (baseFractionalPart.length() == 0)
                ? baseIntegerPart.toString().toUpperCase()
                : baseIntegerPart.toString().toUpperCase() + "." + baseFractionalPart.toString().toUpperCase();
    }

    // Converter de uma base para outra
    public static String dbase2base(String value, int base1, int base2) {
        int dotIndex = value.indexOf('.');
        String integerPartStr = (dotIndex != -1) ? value.substring(0, dotIndex) : value;
        String fractionalPartStr = (dotIndex != -1) ? value.substring(dotIndex + 1) : "";

        long decimalIntegerPart = Long.parseLong(integerPartStr, base1);

        double decimalFractionalPart = 0.0;
        String digits = "0123456789ABCDEF";
        for (int i = 0; i < fractionalPartStr.length(); i++) {
            int digitValue = digits.indexOf(Character.toUpperCase(fractionalPartStr.charAt(i)));
            decimalFractionalPart += digitValue * Math.pow(base1, -(i + 1));
        }

        StringBuilder base2IntegerPart = new StringBuilder();
        if (decimalIntegerPart == 0) {
            base2IntegerPart.append("0");
        } else {
            while (decimalIntegerPart > 0) {
                long remainder = decimalIntegerPart % base2;
                base2IntegerPart.insert(0, Character.forDigit((int) remainder, base2));
                decimalIntegerPart /= base2;
            }
        }

        StringBuilder base2FractionalPart = new StringBuilder();
        int maxPrecision = 10;
        while (decimalFractionalPart > 0 && base2FractionalPart.length() < maxPrecision) {
            decimalFractionalPart *= base2;
            int digit = (int) decimalFractionalPart;
            base2FractionalPart.append(Character.forDigit(digit, base2));
            decimalFractionalPart -= digit;
        }

        return (base2FractionalPart.length() == 0)
                ? base2IntegerPart.toString().toUpperCase()
                : base2IntegerPart.toString().toUpperCase() + "." + base2FractionalPart.toString().toUpperCase();
    }

    // Operações com binários
    public static String dbinEval(String value1, String op, String value2) {
        double decimal1 = bin2double(value1);
        double decimal2 = bin2double(value2);
        double result = 0;

        switch (op) {
            case "+": result = decimal1 + decimal2; break;
            case "-": result = decimal1 - decimal2; break;
            case "*": result = decimal1 * decimal2; break;
            case "/":
                if (decimal2 == 0) return "Erro: Divisão por zero";
                result = decimal1 / decimal2;
                break;
            case "%":
                if (decimal2 == 0) return "Erro: Módulo por zero";
                result = decimal1 % decimal2;
                break;
            default: return "Erro: Operador inválido";
        }
        return double2bin(result);
    }

    // Main
public static void main(String[] args) {
    System.out.println("Guia_02 - Java Tests");
    System.out.println("845963 - Kayky Gabriel Marques\n");

    // 1) bin2double -> comparar como double
    test_equals(bin2double("0.00111"), 0.21875);   // 1/8 + 1/16 + 1/32
    test_equals(bin2double("0.01001"), 0.28125);   // 1/4 + 1/32
    test_equals(bin2double("0.10101"), 0.65625);   // 1/2 + 1/8 + 1/32
    test_equals(bin2double("1.11101"), 1.90625);   // 1 + 1/2 + 1/4 + 1/8 + 1/32
    test_equals(bin2double("11.11001"), 3.78125);  // 3 + 1/2 + 1/4 + 1/32
    System.out.println("1. errorTotalReport = " + test_report());

    // 2) double2bin -> comparar como String
    test_equals(double2bin(0.875000), "0.111");
    test_equals(double2bin(1.250000), "1.01");
    test_equals(double2bin(3.750000), "11.11");
    test_equals(double2bin(4.125000), "100.001");
    test_equals(double2bin(7.625000), "111.101");
    System.out.println("2. errorTotalReport = " + test_report());

    // 3) dbin2base (binário fracionário -> base N) -> Strings corretas
    test_equals(dbin2base("0.010110", 4),  "0.112");
    test_equals(dbin2base("0.100111", 8),  "0.47");
    test_equals(dbin2base("0.101001", 16), "0.A4");
    test_equals(dbin2base("1.110101", 8),  "1.65");
    test_equals(dbin2base("1011.1011", 16),"B.B");
    System.out.println("3. errorTotalReport = " + test_report());

    // 4) dbase2base (base1 -> base2) -> Strings corrigidas
    test_equals(dbase2base("0.213",   4,  2), "0.100111");
    test_equals(dbase2base("0.4D3",  16,  4), "0.103103"); // hex -> base 4 (mapeamento exato)
    test_equals(dbase2base("0.654",   8,  2), "0.1101011");
    test_equals(dbase2base("6.1435",  8,  4), "12.030131");
    test_equals(dbase2base("A.DE5",  16,  4), "22.313211");
    System.out.println("4. errorTotalReport = " + test_report());

    // 5) dbinEval -> somas/sub/mult como String; divisão comparada numericamente; módulo como String
    test_equals(dbinEval("101.011", "+", "10.01"),   "111.101");     // 5.375 + 2.25 = 7.625
    test_equals(dbinEval("1000.010", "-", "10.011"), "101.111");     // 8.25 - 2.375 = 5.875
    test_equals(dbinEval("101.110", "*", "10.101"),  "1111.00011");  // 5.75 * 2.625 = 15.09375
    // Divisão: compara como double para evitar dependência de 32 bits binários exatos
    test_equals(
        bin2double(dbinEval("10110.01", "/", "11.101")),
        bin2double("110.00100011010011110111001011000010") // ~6.13793103448
    );
    test_equals(dbinEval("1100101", "%", "1101"), "1010");           // 101 % 13 = 10 (1010b)
    System.out.println("5. errorTotalReport = " + test_report());

    java.util.Scanner sc = new java.util.Scanner(System.in);
    System.out.print("\n\nApertar ENTER para terminar.");
    sc.nextLine();
    sc.close();
}


}
