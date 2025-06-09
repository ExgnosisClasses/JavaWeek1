public class RelationalLogicalLab {
    public static void main(String[] args) {
        int x = 8, y = 12;

        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y: " + (x > y));
        System.out.println("x < y: " + (x < y));

        // Logical
        boolean result = (x > 5 && y < 15);
        System.out.println("x > 5 && y < 15: " + result);
    }
}
