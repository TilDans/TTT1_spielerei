package foo;

public interface IModel {
    EFieldState getFieldState(int row, int column);

    void setFieldState(int row, int column, EFieldState state);

    String toServerString();

    boolean getWon();
    
    void setWon();

    void setPlayer(IPlayer currentPlayer);

    IPlayer getCurrentPlayer();

    int getMoveCount();
}
