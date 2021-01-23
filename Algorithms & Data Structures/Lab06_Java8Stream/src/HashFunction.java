public class HashFunction {
    private String s;
    private static final int A = 13;
    private static final int M = 31;

    /**
     * Constructor for objects of class HashFunction
     */
    public HashFunction(String s) {
        this.s = s;
    }

    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) { // Uppercase letters
                hash = (s.charAt(i) - 38) + (53 * hash);
            } else if(Character.isLowerCase(s.charAt(i))) { // Lowercase letters
                hash = (s.charAt(i) - 96) + (53 * hash);
            }
        }
        return (A * hash) % 31;
    }

    @Override
    public String toString() {
        return ""+hashCode();
    }

    public static void main(String[] args) {
        String s1 = "he";
        System.out.println(s1 + " : " + new HashFunction(s1).toString());
        String s2 = "is";
        System.out.println(s2 + " : " + new HashFunction(s2).toString());
        String s3 = "Art";
        System.out.println(s3 + " : " + new HashFunction(s3).toString());
        String s4 = "has";
        System.out.println(s4 + " : " + new HashFunction(s4).toString());
        String s5 = "Hat";
        System.out.println(s5 + " : " + new HashFunction(s5).toString());
        String s6 = "this";
        System.out.println(s6 + " : " + new HashFunction(s6).toString());
    }
}