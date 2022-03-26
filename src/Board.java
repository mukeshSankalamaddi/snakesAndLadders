
import java.util.*;
public class Board {
    private final int rows = 10;
    private final int columns = 10;
    private final int numberOfSnakes = 8;
    private final int numberOfLadders = 8;

    private int[][] gameBoard;
    private int[][] snakes;
    private int[][] ladders;

    Map<Player, Integer> playerPositions;
    public Board(List<Player> players){
        this.playerPositions = new HashMap<Player, Integer>();
        for (Player player : players){
            this.playerPositions.put(player, 0);
        }
        gameBoard = new int[rows][columns];
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < columns; col++){
                gameBoard[row][col] = row*rows + col + 1;
            }
        }

        setSnakes();
        setLadders();

    }

    public boolean movePlayer(Player player, int value){
        int position = playerPositions.get(player);
        position += value;
        if (position >= 100){
            playerPositions.put(player, 100);
            return true;
        } else {
            for (int i = 0; i < numberOfSnakes; i++){
                if (snakes[i][0] == position){
                    position = snakes[i][1];
                    playerPositions.put(player, position);

                    System.out.println( player + " moves from " + snakes[i][0] + " to " + snakes[i][1]);
                    return false;
                }
            }
            for (int i = 0; i < numberOfLadders; i++){
                if (ladders[i][0] == position){
                    position = ladders[i][1];
                    playerPositions.put(player, position);
                    System.out.println( player + " takes ladder and moves from " + ladders[i][0] + " to " + ladders[i][1]);

                    return false;
                }
            }

            playerPositions.put(player, position);
            return false;
        }
    }
    private void setSnakes(){
        snakes = new int[numberOfSnakes][2];
        snakes[0][0] = 17;
        snakes[0][1] = 7;
        snakes[1][0] = 54;
        snakes[1][1] = 34;
        snakes[2][0] = 62;
        snakes[2][1] = 19;
        snakes[3][0] = 64;
        snakes[3][1] = 60;
        snakes[4][0] = 87;
        snakes[4][1] = 24;
        snakes[5][0] = 93;
        snakes[5][1] = 73;
        snakes[6][0] = 95;
        snakes[6][1] = 75;
        snakes[7][0] = 99;
        snakes[7][1] = 78;
    }
    private void setLadders(){
        ladders = new int[numberOfLadders][2];
        ladders[0][0] = 4;
        ladders[0][1] = 14;
        ladders[1][0] = 9;
        ladders[1][1] = 31;
        ladders[2][0] = 20;
        ladders[2][1] = 38;
        ladders[3][0] = 28;
        ladders[3][1] = 84;
        ladders[4][0] = 40;
        ladders[4][1] = 59;
        ladders[5][0] = 51;
        ladders[5][1] = 67;
        ladders[6][0] = 63;
        ladders[6][1] = 81;
        ladders[7][0] = 71;
        ladders[7][1] = 91;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        boolean oddRow = true;

        for (int row = rows-1; row >= 0; row--){
            for (int col = 0; col < columns; col++){
                if (oddRow){
                    String pl = "";
                    boolean occupied = false;
                    for (Player temp : playerPositions.keySet()){
                        if (playerPositions.get(temp) == gameBoard[row][columns-1-col]){
                            occupied = true;
                            pl +="'"+temp +"'";
                        }
                    }

                    if (occupied){
                        sb.append(pl);
                    } else {
                        sb.append(gameBoard[row][columns-1-col] + "\t");
                    }
                } else {
                    boolean occupied = false;
                    String pl = "";
                    for (Player temp : playerPositions.keySet()){
                        if (playerPositions.get(temp) == gameBoard[row][col]){
                            occupied = true;
                            pl += ("'"+temp+"'");
                        }
                    }

                    if (occupied){
                        sb.append(pl);
                    } else {
                        sb.append(gameBoard[row][col] + "\t");
                    }
                }
            }
            oddRow = !oddRow;
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}