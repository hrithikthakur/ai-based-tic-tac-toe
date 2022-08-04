package tictactoe;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while (true) {
            Player playerX = null;
            Player playerO = null;
            //take input command from user
            System.out.print("Input Command: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase();
            if("exit".equals(input)) {
                return;
            }
            else if (!input.matches("start\\s+(easy|medium|hard|user)\\s+(easy|medium|hard|user)\\s*")) {
                System.out.println("Bad parameters!");
                continue;
            } else {
                String[] strs = input.split("\\s+");
                playerX = Player.setPlayer(strs[1]);
                playerO = Player.setPlayer(strs[2]);
            }
            //start a new game if user inputs "start" with suitable parameters
            Board board = new Board();
            Game game = new Game(board, playerX, playerO);
            board.printBoard();
            //game loop
            while (!game.playerOWins && !game.playerXWins && !game.draw) {
                playerX.makeMove(game);
                game.switchPlayer();
                board.printBoard();
                game.analyzeGame();
                game.printGameStatus();
                if (game.playerOWins || game.playerXWins || game.draw) {
                    break;
                }
                playerO.makeMove(game);
                game.switchPlayer();
                board.printBoard();
                game.analyzeGame();
                game.printGameStatus();
                if (game.playerOWins || game.playerXWins || game.draw) {
                    break;
                }
            }
        }
    }


    



}

