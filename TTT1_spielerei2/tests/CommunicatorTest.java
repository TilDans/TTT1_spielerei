import java.awt.Point;

import de.mpaap.util.com.*;

public class CommunicatorTest {
    public static void main(String[] args) throws CommunicatorException{
        // TODO Auto-generated method stub
        
        int numResponse;
        int row;
        int col;
        
        Communicator com = new Communicator("localhost", 7890, "UTF-8");
        
        String response = com.communicate("___x__o__\n");
        numResponse = Integer.parseInt(response.trim()) - 1;
        System.out.println(response);
        System.out.println(numResponse);
        
        row = numResponse / 3;
        col = numResponse % 3;
        
        System.out.println(new Point(row, col));
    }
}

