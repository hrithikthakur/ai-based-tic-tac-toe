package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public void makeMove (Game game) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the coordinates: ");
            String n = scanner.nextLine();
            if (!n.matches("\\d\\s*\\d\\s*")) {
                System.out.println("You should enter numbers!");
            } else {
                String[] strs = n.split(" ");
                int row = Integer.parseInt(strs[0]) - 1;
                int col = Integer.parseInt(strs[1]) - 1;
                if (row > 2 || row < 0 || col > 2 || col < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else if (game.board.getToken(row, col) != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    if (game.currentPlayer.equals(game.playerX)) {
                        game.board.setToken(row, col,'X');
                    } else {
                        game.board.setToken(row, col,'O');
                    }
                    break;
                }
            }
        }
    }


}
