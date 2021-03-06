
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomPasswordGenerator {

    Random random = new SecureRandom();

    public String generateSecureRandomPasswordWithRules(HashMap<String, Object> rules) {

        int minimumPasswordLength = (Integer) rules.get("minLength");
        int maximumPasswordLength = (Integer) rules.get("maxLength");
        int randomPasswordLength = random.nextInt(maximumPasswordLength - minimumPasswordLength) + minimumPasswordLength;
        int diffRandomPasswordLengthAndMinChar = randomPasswordLength - minimumPasswordLength;

        Stream<Character> pwdStream = Stream.concat(getRandomNumbers((Integer) rules.get("minNoOfDigits")),
                Stream.concat(getRandomSpecialChars((Integer) rules.get("minNoSpecialCharacters")),
                        Stream.concat(getRandomAlphabets((Integer) rules.get("minNoOfUpperCase"), true),
                                getRandomAlphabets((Integer) rules.get("minNoOfLowerCase"), false))));

        List<Character> charList = pwdStream.collect(Collectors.toList());

        Stream<Character> extraPwdStream = getRandomAlphabets(diffRandomPasswordLengthAndMinChar, true);
        charList.addAll(extraPwdStream.collect(Collectors.toList()));

        Collections.shuffle(charList);
        String password = charList.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        return password;
    }


    public Stream<Character> getRandomAlphabets(int count, boolean upperCase) {
        IntStream characters = null;
        if (upperCase) {
            characters = random.ints(count, 65, 90);
        } else {
            characters = random.ints(count, 97, 122);
        }
        return characters.mapToObj(data -> (char) data);
    }

    public Stream<Character> getRandomNumbers(int count) {
        IntStream numbers = random.ints(count, 48, 57);
        return numbers.mapToObj(data -> (char) data);
    }

    public Stream<Character> getRandomSpecialChars(int count) {
        IntStream specialChars = random.ints(count, 33, 45);
        return specialChars.mapToObj(data -> (char) data);
    }
}