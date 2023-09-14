package foo;

import java.awt.Point;

public interface IPlayer {
    Point getMove(String situation) throws PlayerException;
    String getId();
}
