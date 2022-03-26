import java.util.*;

public class mainCode {

    public static void main(String[] args){
        System.out.println("Welcome to Snakes & Ladders game");

        Scanner sc = new Scanner (System.in);

        int numOfPlayers = 0;
        while (numOfPlayers <= 0 || numOfPlayers >4){
            System.out.print("Please enter the number of player (1-4): " );
            numOfPlayers = sc.nextInt();
        }

        List<Player> players = new ArrayList<Player>();
        for (int i = 1; i <= numOfPlayers; i++){
            Player player = new Player("P" + i);
            players.add(player);
        }

        Board board = new Board(players);

        boolean gameCompleted = false;
        int playerIndex = 0;
        while (!gameCompleted){
            Player currPlayer = players.get(playerIndex);
            int roll = currPlayer.takeTurn();

            gameCompleted = board.movePlayer(currPlayer, roll);

            System.out.println(board);
            System.out.println("-----------------------");

            if (gameCompleted){
                System.out.println(currPlayer + " wins");
            }

            playerIndex++;
            if (playerIndex == numOfPlayers){
                playerIndex = 0;
            }

        }
    }
}
