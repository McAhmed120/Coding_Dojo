import java.util.ArrayList;

public class Test {
    // Existing methods...

    public static void main(String[] args) { 
        Puzzling puzzling = new Puzzling();

        ArrayList<Integer> rolls = puzzling.getTenRolls();
        System.out.println("Ten Rolls: " + rolls);

        // Example 2: Get a random letter with array
        String randomLetterWithArray = puzzling.getRandomLetterWithArray();
        System.out.println("Random Letter with Array: " + randomLetterWithArray);

        // Example 3: Get a random letter
        String randomLetter = puzzling.getRandomLetter();
        System.out.println("Random Letter: " + randomLetter);

        // Example 4: Generate a password
        String password = puzzling.generatePassword();
        System.out.println("Generated Password: " + password);

        // Example 5: Get a new password set
        ArrayList<String> passwordSet = puzzling.getNewPasswordSet(5);
        System.out.println("New Password Set: " + passwordSet);
    }
}
