public class CastingLab {
    public static void main(String[] args) {
        int a = 2;
        double b = 4.8;

        System.out.println("a + b = " + (a + b)); // implicit conversion
        System.out.println("a + (int)b = " + (a + (int)b));
        System.out.println("(int)(a + b) = " + (int)(a + b));
    }
}
