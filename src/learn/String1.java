package learn;

public class String1 {
    public static void main(String[] args) {
        /*
        String a="Gopal Krishnan";
        String b="Gopal Krishnan";
        String c="gopal Krishnan";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equalsIgnoreCase(c));
        System.out.println(a.equals(c));
        System.out.println("Length: "+a.length());
        System.out.println("CharAt: "+a.charAt(0));
        System.out.println("Uppercase: "+a.toUpperCase());
        System.out.println("Lowercase: "+a.toLowerCase());
        System.out.println("Replace: "+a.replace("Gopal","Stanley"));
        System.out.println("Contains : " + a.contains("Joes"));
        System.out.println("Empty : " + a.isEmpty());
        System.out.println("EndWith : " + a.endsWith("es"));
        System.out.println("StartWith : " + a.startsWith("Tut"));
        System.out.println("Substring : " + a.substring(5));
        System.out.println("Substring : " + a.substring(0, 5));
        char[] carray = a.toCharArray();
        for(char i : carray){
            System.out.print(c+ "   ");
        }
        String i=" Tutor ";
        System.out.println("Length: "+c.length());
        System.out.println("C:"+c);
        System.out.println("C Trim :"+c.trim());
        System.out.println("C Trim Length:"+c.trim().length());
        String s = "hello";
        int count = 0;
        for(char ch : s.toCharArray()) {
            if("aeiou".indexOf(ch) != -1) count++;
        }
        System.out.println("Vowels: " + count);

         */
        StringBuffer buffer = new StringBuffer("Gopal");
        System.out.println(buffer);
        buffer.append(" Krishnan");
        System.out.println(buffer);
        buffer.insert(14, " Developer");
        System.out.println(buffer);
        buffer.replace(5, 6," @ ");
        System.out.println(buffer);
        buffer.delete(6, 7);
        System.out.println(buffer);



        StringBuilder builder = new StringBuilder("Gopal");
        System.out.println(builder);
        builder.append(" Krishnan");
        System.out.println(builder);

    }
}