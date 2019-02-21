import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;


public class Randomizer {

    public String generateString() {
        int length = randomNumber();
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString);
        return generatedString;
    }

    public Integer randomNumber(){
        Random random = new Random();
        int randomInt = random.nextInt(31);
        return randomInt;
    }
}
