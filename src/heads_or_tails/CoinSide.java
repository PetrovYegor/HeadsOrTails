package heads_or_tails;

public class CoinSide {
    private final int sideValue;
    private final String sideName;

    CoinSide(int sideValue, String sideName) {
        this.sideValue = sideValue;
        this.sideName = sideName;
    }

    public int getSideValue() {
        return sideValue;
    }

    public String getSideName() {
        return sideName;
    }
}
