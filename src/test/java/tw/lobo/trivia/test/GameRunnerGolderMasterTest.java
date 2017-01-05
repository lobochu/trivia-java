package tw.lobo.trivia.test;

import com.adaptionsoft.games.uglytrivia.Game;

import java.io.*;
import java.util.Random;

//Intentionally duplicates producton GameRunner for now.
public class GameRunnerGolderMasterTest {

  private static boolean notAWinner;

  public static void main(String[] args) throws IOException {

    PrintStream systemOut = System.out;

    final int gameId = 7777;

    //REFACTOR Make the current working directory more explicit?
    final File testRunOutputFile = new File("test-data", String.format("test-run-%d.txt", gameId));
//    PrintWriter canvas = new PrintWriter(new FileWriter(testRunOutputFile));
//    canvas.println("Hello, world!");
//    canvas.flush();
//    canvas.close();


    // REFACTOR Make the game output stream pluggable, since clearly, I want to plug
    // something else into it.
    System.setOut(new PrintStream(testRunOutputFile));
    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");

    // We can conveniently use the game ID directly as a random number generator seed.
    Random rand = new Random(gameId);

    do {
      aGame.roll(rand.nextInt(5) + 1);

      if (rand.nextInt(9) == 7) {
        notAWinner = aGame.wrongAnswer();
      } else {
        notAWinner = aGame.wasCorrectlyAnswered();
      }
    } while (notAWinner);

    System.setOut(systemOut);

  }
}
