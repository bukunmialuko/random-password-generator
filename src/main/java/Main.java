
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        RandomPasswordGenerator rpg = new RandomPasswordGenerator();
        HashMap<String, Object> rules = new HashMap<>();
        rules.put("minLength", 7);
        rules.put("maxLength", 10);

        // Minimum rules
        rules.put("minNoOfLowerCase", 0);
        rules.put("minNoOfUpperCase", 1);
        rules.put("minNoOfDigits", 3);
        rules.put("minNoSpecialCharacters", 2);
        System.out.println("===> GENERATED PASSWORD : " + rpg.generateSecureRandomPasswordWithRules(rules));

    }
}




