package foo;

import java.awt.Point;

import de.mpaap.util.com.Communicator;
import de.mpaap.util.com.CommunicatorException;

public class NetworkPlayer implements IPlayer {
    private Communicator com;
    private String id;

    public NetworkPlayer(String host) {
        com = new Communicator(host, 7890, "UTF-8");
        id = host;
    }

    @Override
    public Point getMove(String situation) throws PlayerException {
        try {
            String response = com.communicate(situation);
            if (response.startsWith("Error")) {
                throw new PlayerException(response);
            }
            int numResponse = Integer.parseInt(response.trim()) - 1;
            int row = numResponse / 3;
            int col = numResponse % 3;
            return new Point(row, col);
        } catch (CommunicatorException | NumberFormatException e) {
            throw new PlayerException(e);
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
