import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    
    TicTacToe Game = new TicTacToe();
    Scanner scan = new Scanner(System.in);
    Boolean winner = false;
    Boolean turnComplete = false;
    String input;
    int commaIndex;
    int row;
    int column;

    while (!winner) {

      if (Game.getTurn() % 2 == 0) {
        System.out.println(
            "First Player, its your turn! Enter the row and column you would like to play in seperated by a comma:");
      } else {
        System.out.println(
            "Second Player, its your turn! Enter the row and column you would like to play in seperated by a comma:");
      }
      turnComplete = false;

      System.out.println("++++++++++++++++++++++++++++");
      Game.printBoard();
      System.out.println("++++++++++++++++++++++++++++");

      while (!turnComplete) {

        input = scan.nextLine();
        System.out.println("++++++++++++++++++++++++++++");
        commaIndex = input.indexOf(",");
        row = Integer.parseInt(input.substring(0, commaIndex));
        column = Integer.parseInt(input.substring(commaIndex + 1));

        if (Game.pickLocation(row, column)) {

          Game.takeTurn(row, column);
          if (Game.checkWin()) {
            scan.close();

            if (Game.getTurn() % 2 == 0) {
              System.out.println("Game Over. O Wins!");
            } else {
              System.out.println("Game Over. X Wins!");
            }
            winner = true;
            break;
          }
          turnComplete = true;

        } else {
          System.out.println("That space is unavailable. Please enter another row and column.");
        }

      }
    }
  }
}
