package co.iichi.shrine.util;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created by sat8bit on 2016/07/03.
 */
public class IdentifierUtils {

    enum Type {
        ACCOUNT,
        ADDITION,
        SUBTRACTION,
        TRANSFER,
    }

    private static final Integer ID_DIGIT = 12;

    private static final String ACCOUNT_PREFIX = "ac_";
    private static final String ADDITION_PREFIX = "ad_";
    private static final String SUBTRACTION_PREFIX = "su_";
    private static final String TRANSFER_PREFIX = "tr_";

    public static final char[] CHARS = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();

    public static String generateAccountId() {
        return generateIdentifier(Type.ACCOUNT);
    }

    public static String generateAdditionId() {
        return generateIdentifier(Type.ADDITION);
    }

    public static String generateSubtractionId() {
        return generateIdentifier(Type.SUBTRACTION);
    }

    public static String generateTransferId() {
        return generateIdentifier(Type.TRANSFER);
    }

    private static String generateIdentifier(Type type) {
        switch (type) {
            case ACCOUNT:
                return ACCOUNT_PREFIX + randomStringBase58(ID_DIGIT - ACCOUNT_PREFIX.length());
            case ADDITION:
                return ADDITION_PREFIX + randomStringBase58(ID_DIGIT - ADDITION_PREFIX.length());
            case SUBTRACTION:
                return SUBTRACTION_PREFIX + randomStringBase58(ID_DIGIT - SUBTRACTION_PREFIX.length());
            case TRANSFER:
                return TRANSFER_PREFIX + randomStringBase58(ID_DIGIT - TRANSFER_PREFIX.length());
        }

        // not reachable
        throw new IllegalArgumentException("Unknown Type[" + type + "]");
    }

    private static String randomStringBase58(Integer digit) {

        StringBuffer stringBuffer = new StringBuffer();

        for(Integer i = 0; i < digit; i++) {
            stringBuffer.append(CHARS[RandomUtils.nextInt(0, CHARS.length)]);
        }

        return stringBuffer.toString();
    }
}
