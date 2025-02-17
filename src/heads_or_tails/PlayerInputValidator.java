package heads_or_tails;

public class PlayerInputValidator {
    boolean isInputCorrect(String source) {
        if (isNullOrEmpty(source)) {
            return false;
        }
        if (!isOneSymbolLength(source)) {
            return false;
        }
        if (!isDigit(source)) {
            return false;
        }
        return isOneOrZero(source);
    }

    private static boolean isNullOrEmpty(String source) {
        return (source == null || source.trim().isEmpty());
    }

    private static boolean isOneSymbolLength(String source) {
        return source.length() == 1;
    }

    private static boolean isDigit(String source) {
        return Character.isDigit(source.charAt(0));
    }

    private static boolean isOneOrZero(String source) {
        int value = Integer.parseInt(source);
        return value == 0 || value == 1;
    }
}
