package tictactoe;

public class Board {
    private char[][] board;
    /* static final int FIRST = 0  */
    /* static final int SECOND = 1  */
    /* static final int THIRD = 2  */

    public Board(String str) {
        this.board = convertToBoard(str);
    }
    public Board(){
        this.board = convertToBoard("         ");
    }

    //a function to count the no. of X on the board
    public  int xCounter() {
        int countX = 0;
        for (int row = 0; row < 3; row++) {
            for (int col  = 0; col  < 3; col++) {
                if (this.getToken(row , col) == 'X') {
                    countX++;
                }
            }
        }
        return countX;
    }
    //a function to count the no. of O on the board
    public  int oCounter() {
        int countO = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (this.getToken(row , col) == 'O') {
                    countO++;
                }
            }
        }
        return countO;
    }
    //a function to count the no. of blank cells left on the board
    public int spaceCounter() {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (this.getToken(row ,col ) == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("| %c %c %c |\n", this.getToken(i,0), this.getToken(i,1), this.getToken(i,2));
        }
        System.out.println("---------");
    }

    //convert a given string to a 2D char array board
    private static char[][] convertToBoard(String str) {
        char[][] cs = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cs[i][j] = str.charAt(3 * i + j);
            }
        }
        return cs;
    }

    //replace all the blank cells with ' '
    private static char[][] replace_(char[][] board){
        for (int row =0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '_') {
                    board[row][col] = ' ';
                }
            }
        }
        return board;
    }
    
    public void setToken(int row, int col, char token) {
        if (token == 'X' || token == 'O' || token == ' ') {
            this.board[row][col] = token;
        } else{
            System.out.println("Invalid token!");
        }
    }
    
    public char getToken(int row, int col) {
        return this.board[row][col];
    }

    public int getNumberOfEmptyCells() {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (this.getToken(row , col) == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isEmpty(int row, int col) {
        return this.getToken(row, col) == ' ';
    }

    public char[][] getBoard() {
        return board;
    }
}
