public class UnaryLab {
    public static void main(String[] args) {
        int a = 5;
        int pre = ++a; // increment a then assigne
        a = 5;         // reset a
        int post = a++; // assign a then increment
        System.out.println("post-increment: " + post);
        System.out.println("pre-increment:: " + pre);
    }
}
