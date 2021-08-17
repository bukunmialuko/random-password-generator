
import java.util.HashMap;

public class Main {

    // The minimum password length must length nut be less
    /// than the sum of the minimum rules
    public static void main(String[] args) {
        RandomPasswordGenerator rpg = new RandomPasswordGenerator();
        HashMap<String, Object> rules = new HashMap<>();
        rules.put("minLength", 7);
        rules.put("maxLength", 10);

        // Minimum rules
        // Zero implies, no limit
        rules.put("minNoOfLowerCase", 0);
        rules.put("minNoOfUpperCase", 1);
        rules.put("minNoOfDigits", 2);
        rules.put("minNoSpecialCharacters", 4);
        System.out.println("===> GENERATED PASSWORD : " + rpg.generateSecureRandomPasswordWithRules(rules));

    }
}




