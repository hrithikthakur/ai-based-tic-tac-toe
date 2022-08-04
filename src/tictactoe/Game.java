package tictactoe;

public class Game {
    Player currentPlayer;
    boolean playerXWins, playerOWins, draw;
    Player playerX, playerO;
    Board board;

    static boolean exit = false;
    public Game(Board board, Player playerXX, Player playerOO){
        playerXWins = false;
        playerOWins = false;
        draw = false;
        this.board = board;
        this.playerX = playerXX;
        this.playerO = playerOO;
        this.currentPlayer = playerX;
    }
    private  void verticalAnalyzer() {
        for (int i = 0; i < 3; i++) {
            if (this.board.getToken(i, 0) == this.board.getToken(i, 1) && this.board.getToken(i, 1) == this.board.getToken(i, 2)) {
                if (this.board.getToken(i,0) == 'X') {
                    playerXWins = true;
                } else if (this.board.getToken(i,0) == 'O') {
                    playerOWins = true;
                }
            }
        }
    }
    //horizontal analyzer
    private  void horizontalAnalyzer(){
        for (int i = 0; i < 3; i++) {
            if (this.board.getToken(0,i) == this.board.getToken(1,i) && this.board.getToken(1,i) == this.board.getToken(2,i)) {
                if (this.board.getToken(0,i) == 'X') {
                    playerXWins = true;
                } else if (this.board.getToken(0,i) == 'O') {
                    playerOWins = true;
                }
            }
        }
    }
    //diagonal Analyzer
    private   void diagonalAnalyzer() {
        if (this.board.getToken(0,0) == this.board.getToken(1,1) && this.board.getToken(1,1) == this.board.getToken(2,2)) {
            if (this.board.getToken(0,0) == 'X') {
                playerXWins = true;
            } else if (this.board.getToken(0,0) == 'O') {
                playerOWins = true;
            }
        }
        if (this.board.getToken(2,0) == this.board.getToken(1,1) && this.board.getToken(1,1) == this.board.getToken(0,2)) {
            if (this.board.getToken(2,0) == 'X') {
                playerXWins = true;
            } else if (this.board.getToken(2,0) == 'O') {
                playerOWins = true;
            }
        }
    }
    //game Analyzer
    public void analyzeGame() {
        //vertical
        verticalAnalyzer();
        //horizontal
        horizontalAnalyzer();
        //diagonals
        diagonalAnalyzer();

    }

    public void printGameStatus() {
        if (playerXWins) {
            System.out.println("X wins!");
        } else if (playerOWins) {
            System.out.println("O wins!");
        } else if (this.board.spaceCounter() == 0) {
            draw = true;
            System.out.println("Draw!");
        }
    }
    public void switchPlayer(){
        this.currentPlayer = this.currentPlayer ==  playerX ? playerO : playerX;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public char getCurrentPlayerChar() {
        return this.currentPlayer == playerX ? 'X' : 'O';
    }

    public char getOpponentPlayerChar() {
        return this.currentPlayer == playerX ? 'O' : 'X';
    }
}
