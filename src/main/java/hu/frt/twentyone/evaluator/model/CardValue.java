package hu.frt.twentyone.evaluator.model;

public enum CardValue {
    ALSO(2), FELSO(3), KIRALY(4), HET(7), NYOLC(8), KILENC(9), TIZ(10), ASZ(11);

    private final int intValue;

    CardValue(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }
}
