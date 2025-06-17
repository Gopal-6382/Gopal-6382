import java.util.Arrays;

public class CapitalizeWords {
    public static void main(String[] args) {
//        String s = "java    programming   language";
//        String[] words = s.split(" ");
//        System.out.println(Arrays.toString(words));
//        StringBuilder result = new StringBuilder();
//        for (String w1 : words)
//            //result.append(Character.toUpperCase(w1.charAt(0))).append(w1.substring(1)).append(" ");
//            result.append(w1.toUpperCase()).append(" ");
//        System.out.println(result.toString().trim());

        String sentence = "JAVA    PROGRAMMING   LANGUAGE";
        String[] words = sentence.trim().split("  ");
        StringBuilder result = new StringBuilder();

        for (String w1 : words) {
            result.append(w1.toUpperCase()).append(" ");
        }

        System.out.println(result.toString().trim());

    }
}
