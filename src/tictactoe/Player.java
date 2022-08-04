package tictactoe;

abstract class Player {
     abstract void makeMove(Game game);

     //add  a foo method to Player class
    public static Player setPlayer(String player) {
        if ("easy".equals(player) || "medium".equals(player) || "hard".equals(player)) {
            return new AIPlayer(player);
        }
        else if ("user".equals(player)) {
            return new HumanPlayer();
        }
        else {
            return null;
        }
    }
}
