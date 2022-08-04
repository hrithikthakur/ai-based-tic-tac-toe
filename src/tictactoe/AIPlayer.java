package tictactoe;
import java.util.Random;

public class AIPlayer extends Player {
    private String level;

    public AIPlayer(String level) {
        this.level = level;
    }

    @Override
    public void makeMove(Game game) {
        System.out.printf("Making move level \"%s\"\n", this.getLevel());
        if (this.getLevel().equals("easy")) {
            makeRandomMove(game);
            return;
        } else if (this.getLevel().equals("medium")) {
            if (game.board.getNumberOfEmptyCells() > 6) {
                makeRandomMove(game);
                return;
            } else {

                if (horizontalChecker(game)) {
                    return;
                } else if (verticalChecker(game)) {

                    return;
                } else if (diagonalChecker(game)) {

                    return;
                } else {
                    makeRandomMove(game);

                    return;
                }
            }


        } else if (this.getLevel().equals("hard")) {
            //implement hard level
            makeBestMove(game);

        }
    }

    public void makeRandomMove(Game game) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (game.board.getToken(row, col) != ' ');
        if (game.getCurrentPlayer().equals(game.playerX)) {
            game.board.setToken(row, col, 'X');
        } else {
            game.board.setToken(row, col, 'O');
        }
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        if (level.equals("easy") || level.equals("medium") || level.equals("hard")) {
            this.level = level;
        } else {
            System.out.println("Invalid level");
        }
    }


    private boolean horizontalChecker(Game game) {
        char c = game.getCurrentPlayerChar();
        for (int row = 0; row < 3; row++) {
            if (game.board.getToken(row, 0) == game.board.getToken(row, 1) && !game.board.isEmpty(row, 1) && game.board.getToken(row, 2) == ' ') {
                game.board.setToken(row, 2, c);
                return true;
            } else if (game.board.getToken(row, 1) == game.board.getToken(row, 2) && !game.board.isEmpty(row, 2) && game.board.getToken(row, 0) == ' ') {
                game.board.setToken(row, 0, c);
                return true;
            } else if (game.board.getToken(row, 2) == game.board.getToken(row, 0) && !game.board.isEmpty(row, 0) && game.board.getToken(row, 1) == ' ') {
                game.board.setToken(row, 1, c);
                return true;
            }
        }
        return false;
    }

    private boolean verticalChecker(Game game) {
        char c = game.getCurrentPlayerChar();
        for (int col = 0; col < 3; col++) {
            if (game.board.getToken(0, col) == game.board.getToken(1, col) && !game.board.isEmpty(1, col) && game.board.getToken(2, col) == ' ') {
                game.board.setToken(2, col, c);
                return true;
            } else if (game.board.getToken(1, col) == game.board.getToken(2, col) && !game.board.isEmpty(2, col) && game.board.getToken(0, col) == ' ') {
                game.board.setToken(0, col, c);
                return true;
            } else if (game.board.getToken(2, col) == game.board.getToken(0, col) && !game.board.isEmpty(0, col) && game.board.getToken(1, col) == ' ') {
                game.board.setToken(1, col, c);
                return true;
            }
        }
        return false;
    }

    private boolean diagonalChecker(Game game) {
        char c = game.getCurrentPlayerChar();
        if (game.board.getToken(0, 0) == game.board.getToken(1, 1) && !game.board.isEmpty(1, 1) && game.board.getToken(2, 2) == ' ') {
            game.board.setToken(2, 2, c);
            return true;
        } else if (game.board.getToken(1, 1) == game.board.getToken(2, 2) && !game.board.isEmpty(2, 2) && game.board.getToken(0, 0) == ' ') {
            game.board.setToken(0, 0, c);
            return true;
        } else if (game.board.getToken(2, 2) == game.board.getToken(0, 0) && !game.board.isEmpty(0, 0) && game.board.getToken(1, 1) == ' ') {
            game.board.setToken(1, 1, c);
            return true;
        } else if (game.board.getToken(1, 1) == game.board.getToken(0, 2) && !game.board.isEmpty(0, 2) && game.board.getToken(2, 0) == ' ') {
            game.board.setToken(2, 0, c);
            return true;
        } else if (game.board.getToken(1, 1) == game.board.getToken(2, 0) && !game.board.isEmpty(2, 0) && game.board.getToken(0, 2) == ' ') {
            game.board.setToken(0, 2, c);
            return true;
        } else if (game.board.getToken(0, 2) == game.board.getToken(2, 0) && !game.board.isEmpty(2, 0) && game.board.getToken(1, 1) == ' ') {
            game.board.setToken(1, 1, c);
            return true;
        }
        return false;
    }

    static int evaluate(Game game)
    {
        Board b = game.board;
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++)
        {
            if (b.getToken(row, 0) == b.getToken(row, 1) &&
                    b.getToken(row, 1) == b.getToken(row, 2))
            {
                if (b.getToken(row, 0) == game.getCurrentPlayerChar())
                    return +10;
                else if (b.getToken(row, 0) == game.getOpponentPlayerChar())
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if (b.getToken(0, col) == b.getToken(1, col) &&
                    b.getToken(1, col) == b.getToken(2, col))
            {
                if (b.getToken(0, col) == game.getCurrentPlayerChar())
                    return +10;
                else if (b.getToken(0, col) == game.getOpponentPlayerChar())
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b.getToken(0, 0) == b.getToken(1, 1) &&
                b.getToken(1, 1) == b.getToken(2, 2))
        {
            if (b.getToken(0, 0) == game.getCurrentPlayerChar())
                return +10;
            else if (b.getToken(0, 0) == game.getOpponentPlayerChar())
                return -10;
        }

        if (b.getToken(0, 2) == b.getToken(1, 1) && b.getToken(1, 1) == b.getToken(2, 0))
        {
            if (b.getToken(0, 2) == game.getCurrentPlayerChar())
                return +10;
            else if (b.getToken(0, 2) == game.getOpponentPlayerChar())
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    static int minimax(Game game, boolean isMax) {
        int score = evaluate(game);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10 || score == -10){
            return score;
        } else if (game.board.getNumberOfEmptyCells() == 0) {
            return 0;
        }

        // If this maximizer's move
        if (isMax)
        {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (game.board.isEmpty(i, j))
                    {
                        // Make the move
                        game.board.setToken(i,j, game.getCurrentPlayerChar());

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(game, !isMax));

                        // Undo the move
                        game.board.setToken(i,j,' ');
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else
        {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (game.board.isEmpty(i, j))
                    {
                        // Make the move
                        game.board.setToken(i,j, game.getOpponentPlayerChar());

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(game, !isMax));

                        // Undo the move
                        game.board.setToken(i,j,' ');
                    }
                }
            }
            return best;
        }
    }

    static void makeBestMove(Game game)
    {
        int bestVal = -1000;
        int bestRow = -1;
        int bestCol = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                // Check if cell is empty
                if (game.board.isEmpty(i, j))
                {
                    // Make the move
                    game.board.setToken(i, j, game.getCurrentPlayerChar());

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax(game, false);

                    // Undo the move
                    game.board.setToken(i, j, ' ');

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal)
                    {
                        bestRow = i;
                        bestCol = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        game.board.setToken(bestRow, bestCol, game.getCurrentPlayerChar());
    }

}
