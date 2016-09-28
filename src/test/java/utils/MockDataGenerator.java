package utils;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class MockDataGenerator {

    public static String emailGenerator () {
        return RandomStringUtils.randomAlphanumeric(20) + "@imaginarymail.com";
    }

    private static Random random = new Random(System.currentTimeMillis());

    //this can be extracted to a seed file with more card issuers and prefixes
    public static final String[] VISA_PREFIX = new String[] { "4539",
            "4556", "4916", "4532", "4929", "40240071", "4485", "4716", "4" };


    public static String generate(int length) {
        Random rand = new Random();
        int index = rand.nextInt(VISA_PREFIX.length);
        String bin = VISA_PREFIX[index];

        // Nr of random digits to generate is:
        // total length of the card number - the card prefix - the check digit at the end
        int randomNumberLength = length - (bin.length() + 1);

        StringBuilder builder = new StringBuilder(bin);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        // Do the Luhn algorithm to generate the check digit.
        int checkDigit = getCheckDigit(builder.toString());
        builder.append(checkDigit);

        return builder.toString();
    }

    // generate the check digit as per Luhn algorithm
    private static int getCheckDigit(String number) {

        int sum = 0;
        for (int i = 0; i < number.length(); i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of 10.
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }


}
