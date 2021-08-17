
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        RandomPasswordGenerator rpg = new RandomPasswordGenerator();
        HashMap<String, Object> rules = new HashMap<>();
        rules.put("minLength", 5);
        rules.put("maxLength", 12);

        // Constraint 1 : Sum of these rules must not be greater than minimum password length.
        // Constraint 2 : Zero implies, no limit.
        rules.put("minNoOfLowerCase", 0);
        rules.put("minNoOfUpperCase", 1);
        rules.put("minNoOfDigits", 1);
        rules.put("minNoSpecialCharacters", 3);
        System.out.println("===> GENERATED PASSWORD : " + rpg.generateSecureRandomPasswordWithRules(rules));


    }
}

