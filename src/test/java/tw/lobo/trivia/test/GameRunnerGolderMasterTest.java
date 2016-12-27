package tw.lobo.trivia.test;

import com.adaptionsoft.games.uglytrivia.Game;

import java.util.Random;

//Intentionally duplicates producton GameRunner for now.
public class GameRunnerGolderMasterTest {

  private static boolean notAWinner;

  public static void main(String[] args) {
    Game aGame = new Game();

    aGame.add("Chet");
    aGame.add("Pat");
    aGame.add("Sue");

    Random rand = new Random(7777);

    do {
      aGame.roll(rand.nextInt(5) + 1);

      if (rand.nextInt(9) == 7) {
        notAWinner = aGame.wrongAnswer();
      } else {
        notAWinner = aGame.wasCorrectlyAnswered();
      }
    } while (notAWinner);

  }
}
