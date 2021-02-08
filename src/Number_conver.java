import java.util.Locale;
import java.util.Scanner;
public class Number_conver {
    //    public GUI(){
//        JFrame frame = new JFrame();
//        JPanel panel = new JPanel();
//        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
//        panel.setLayout( new GridLayout(0, 1));
//
//    }
    public static String DecimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary = decimal % 2 + binary; // здесь храню остаток от деления
            decimal = decimal / 2;
        }
        return binary;
    }

    public static String DecimalToOctal(int decimal) {
        String octal = "";
        while (decimal != 0) {
            octal = decimal % 8 + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    public static String DecimalToHex(int decimal) {
        String hexadecimal = "";
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            hexadecimal = hex[decimal % 16] + hexadecimal;
            decimal = decimal / 16;
        }
        return hexadecimal;
    }

    public static int BinaryToDecimal(int binary) {
        // int binary = Integer.parseInt(bin);
        int n = 0;
        int decimal = 0;
        while (binary != 0) {
            decimal += (binary % 10) * Math.pow(2, n);
            binary = binary / 10;
            n++;
        }
        return decimal;
    }

    public static int OctalToDecimal(int octal) {
        int n = 0;
        int decimal = 0;
        while (octal != 0) {
            decimal += (octal % 10) * Math.pow(8, n);
            octal = octal / 10;
            n++;
        }
        return decimal;
    }

    public static int HexToDecimal(String hexadecimal) {
        int decimal = 0;
        String hexString = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int len = hexadecimal.length();
        for (int i = 0; i < len; i++) {
            int num = hexString.indexOf(hexadecimal.charAt(i));
            decimal = decimal * 16 + num;
        }
        return decimal;
    }

    public static String addingBinary(int n1, int n2) {
        int i = 0, remain = 0;
        int[] numb = new int[20];
        while (n1 != 0 || n2 != 0) {
            numb[i++] = (int) ((n1 % 10 + n2 % 10 + remain) % 2);
            remain = (int) ((n1 % 10 + n2 % 10 + remain) / 2);
            n1 = n1 / 10;
            n2 = n2 / 10;
        }
        if (remain != 0) {
            numb[i++] = remain;
        }
        i--;
        String res = "";
        while (i >= 0) {
            res += numb[i--];
        }
        return res;
    }


    public static int binaryproduct(int binary1, int binary2) {

        int multiply = 0;
        int digit, factor = 1;
        while (binary2 != 0) {
            digit = (int) (binary2 % 10);
            if (digit == 1) {
                binary1 = binary1 * factor;
                multiply = product((int) binary1, (int) multiply);
            } else {
                binary1 = binary1 * factor;
            }
            binary2 = binary2 / 10;
            factor = 10;
        }
        return multiply;
    }


    public static int product(int binary1, int binary2){
        int i = 0, remainder = 0;
        int[] sum = new int[20];
        int binary_prod_result = 0;

        while (binary1 != 0 || binary2 != 0)
        {
            sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
            remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0)
        {
            sum[i++] = remainder;
        }
        --i;
        while (i >= 0)
        {
            binary_prod_result = binary_prod_result * 10 + sum[i--];
        }
        return binary_prod_result;
    }






    public static void main(String[] args) {
        System.out.println(DecimalToBinary(5));
        System.out.println(DecimalToOctal(16));
        System.out.println(DecimalToHex(15));
        System.out.println(BinaryToDecimal(10101));
        System.out.println(OctalToDecimal(10));
        System.out.println(HexToDecimal("25"));
        System.out.println(addingBinary(11100, 10101));
        System.out.println(binaryproduct(110, 101));

    }


}
