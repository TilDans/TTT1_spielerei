package foo;

public enum EFieldState {
    EMPTY ('_'), CROSS ('x'), CIRCLE ('o');

    private final char SYMBOL;

    private EFieldState(char sYMBOL) {
        SYMBOL = sYMBOL;
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
}
