public class ArithmeticLab {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));  // Integer division
        System.out.println("Modulus: " + (a % b));

        // Assignment
        a += 5;
        System.out.println("Updated a (a += 5): " + a);
    }
}
