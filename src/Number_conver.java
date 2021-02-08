import java.util.Scanner;
public class Number_conver {
    public static String DecimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary = decimal % 2 + binary;
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

        int mult = 0;
        int digit, factor = 1;
        while (binary2 != 0) {
            digit = (int) (binary2 % 10);
            if (digit == 1) {
                binary1 = binary1 * factor;
                mult = product((int) binary1, (int) mult);
            } else {
                binary1 = binary1 * factor;
            }
            binary2 = binary2 / 10;
            factor = 10;
        }
        return mult;
    }


    public static int product(int binary1, int binary2){
        int i = 0, remain = 0;
        int[] sum = new int[20];
        int binary_prod = 0;

        while (binary1 != 0 || binary2 != 0)
        {
            sum[i++] = (binary1 % 10 + binary2 % 10 + remain) % 2;
            remain = (binary1 % 10 + binary2 % 10 + remain) / 2;
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remain != 0)
        {
            sum[i++] = remain;
        }
        --i;
        while (i >= 0)
        {
            binary_prod = binary_prod * 10 + sum[i--];
        }
        return binary_prod;
    }

    public static int AddingOctal ( int a, int b) {
            int sum = 0, digit = 0, remin = 0, rank = 1;
            while (a > 0 || b > 0 || remin  > 0) {
                digit = a % 10 + b % 10 + remin;
                if (digit > 7) {
                    remin = 1;
                    digit %= 8;
                } else
                    remin = 0;
                sum += digit * rank;
                rank = rank * 10;
                a = a  /  10;
                b = b / 10;
            }
            return sum;
    }





    public static void main(String[] args) {
        int n = 1;

        Scanner scanner = new Scanner(System.in);
        while (n != 0) {
            System.out.println("Choose what do you want to ?");
            System.out.println("Menu: ");
            System.out.println("1. DecimalToBinary: ");
            System.out.println("2. DecimalToOctal: ");
            System.out.println("3. DecimalToHex: ");
            System.out.println("4. BinaryToDecimal: ");
            System.out.println("5. OctalToDecimal: ");
            System.out.println("6. HexToDecimal: ");
            System.out.println("7. Adding Binary: ");
            System.out.println("8. Binary Product: ");
            System.out.println("9. Adding Octal: ");
            System.out.println("0. Exit: ");
            int input = scanner.nextInt();
            n = input;

            if (n == 0){
                System.exit(0);
            }
            else if(n == 1){
                System.out.println("1. DecimalToBinary: ");
                System.out.println("Enter: ");
                int input1 = scanner.nextInt();
                System.out.println(DecimalToBinary(input1));
            }
            else if(n == 2){
                System.out.println("2. DecimalToOctal: ");
                System.out.println("Enter: ");
                int input1 = scanner.nextInt();
                System.out.println(DecimalToOctal(input1));
            }
            else if(n == 3){
                System.out.println("3. DecimalToHex: ");
                System.out.println("Enter: ");
                int input1 = scanner.nextInt();
                System.out.println(DecimalToHex(input1));
            }
            else if(n == 4){
                System.out.println("4. BinaryToDecimal: ");
                System.out.println("Enter: ");
                int input1 = scanner.nextInt();
                System.out.println(BinaryToDecimal(input1));
            }
            else if(n == 5){
                System.out.println("5. OctalToDecimal: ");
                System.out.println("Enter: ");
                int input1 = scanner.nextInt();
                System.out.println(OctalToDecimal(input1));
            }
            else if(n == 6){
                System.out.println("6. HexToDecimal: ");
                System.out.println("Enter: ");
                String input1 = scanner.next();
                System.out.println(HexToDecimal(input1));
            }
            else if(n == 7){
                System.out.println("7. Adding Binary: ");
                System.out.println("Enter first number: ");
                int input1 = scanner.nextInt();
                System.out.println("Enter second number: ");
                int input2 = scanner.nextInt();
                System.out.println(addingBinary(input1, input2));
            }
            else if(n == 8){
                System.out.println("8. Binary Product: ");
                System.out.println("Enter first number: ");
                int input1 = scanner.nextInt();
                System.out.println("Enter second number: ");
                int input2 = scanner.nextInt();
                System.out.println(binaryproduct(input1, input2));
            }
            else if(n == 9){
                System.out.println("9. Adding Octal: ");
                System.out.println("Enter first number: ");
                int input1 = scanner.nextInt();
                System.out.println("Enter second number: ");
                int input2 = scanner.nextInt();
                System.out.println(AddingOctal(input1, input2));
            }
        }

    }

}
