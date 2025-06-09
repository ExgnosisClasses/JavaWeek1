
public class Runner {
        public static void main(String[] args) {


            // Step 1
            String name = "Alice";

            // Step 2
            System.out.println("Uppercase: " + name.toUpperCase());
            System.out.println("Lowercase: " + name.toLowerCase());

            // Step 3
            System.out.println("Length: " + name.length());

            // Step 4
            System.out.println("First character: " + name.charAt(0));


            // Comparison

            String newName = name;
            if (name.equals(newName)) {
                System.out.println("The Strings are equivalent.");
            } else {
                System.out.println("The Strings NOT equivalent.");
            }
            if (name == newName) {
                System.out.println("The Strings are == equal.");
            } else {
                System.out.println("The Strings are NOT == equal.");
            }

            newName = "Alice";
        }
    }
