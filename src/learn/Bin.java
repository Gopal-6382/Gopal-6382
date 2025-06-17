package learn;/*
public static void convertToDecimal(String binary) {
    int decimal = 0;
    int power = 0;

    // Loop through the binary number from right to left
    for (int i = binary.length() - 1; i >= 0; i--) {
        char bit = binary.charAt(i);

        // Only allow '0' or '1'
        if (bit == '1') {
            decimal += Math.pow(2, power);
        } else if (bit != '0') {
            System.out.println("Invalid binary number.");
            return;
        }

        power++;
    }

    System.out.println("Decimal: " + decimal);
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Binary Number: ");
    String binary = scanner.nextLine();

    convertToDecimal(binary);
}


 */

class bin{
    public static int dec(int d){
        int pow=0,rem=0;
        int i=0,dec=0;
        while (d!=0){
             rem=d%10;
             dec+=(rem)*(Math.pow(2,pow));
             d=d/10;
            pow++;
        }
        return dec;
    }
    public static void main(String[] args) {
        System.out.println(dec(1100));
    }
}