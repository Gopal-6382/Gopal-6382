public class Count_Words {
    public static void main(String[] args) {
        String s = "Hello World 123 ngngoon 95-J?q$ 904j,.xzx.3q,l;3q/.q4][3f5mgopmgre";
        int v = 0, c = 0, l = 0, d = 0, sp = 0;
        for (char ch : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch) != -1) v++;
            if (Character.isUpperCase(ch)) c++;
            if (Character.isLowerCase(ch)) l++;
            if (Character.isDigit(ch)) d++;
            if (ch == ' ') sp++;
        }
        System.out.println("Vowels: " + v + ", Capitals: " + c + ", Lowercase: " + l + ", Digits: " + d + ", Spaces: " + sp);
        String s1 = "Java";
        String rev = new StringBuilder(s1).reverse().toString();
        System.out.println("String reverse " + rev);
        String s5 = "Hello World 123 ngngoon 95-J?q$ 904j,.xzx.3q,l;3q/.q4][3f5mgopmgre";
        int vowels = 0, uppercase = 0, lowercase = 0, digits = 0, spaces = 0;

        for (char ch : s5.toCharArray()) {

            // Vowel check using ASCII directly
            if ((int) ch == 65 || (int) ch == 69 || (int) ch == 73 || (int) ch == 79 || (int) ch == 85 ||  // A E I O U
                    (int) ch == 97 || (int) ch == 101 || (int) ch == 105 || (int) ch == 111 || (int) ch == 117) // a e i o u
                vowels++;

            if ((int) ch >= 65 && (int) ch <= 90) uppercase++;      // A–Z
            if ((int) ch >= 97 && (int) ch <= 122) lowercase++;     // a–z
            if ((int) ch >= 48 && (int) ch <= 57) digits++;         // 0–9
            if ((int) ch == 32) spaces++;                        // space
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Uppercase: " + uppercase);
        System.out.println("Lowercase: " + lowercase);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);

        // Reverse a string using ASCII concept (optional)
        String s9 = "Java";
        char[] arr = s9.toCharArray();
        StringBuilder rev1 = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            rev1.append(arr[i]);
        }
        System.out.println("Reversed string: " + rev1);
    }
}

