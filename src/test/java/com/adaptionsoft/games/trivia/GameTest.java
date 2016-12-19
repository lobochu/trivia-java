package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lobo on 2016/12/19.
 */
public class GameTest {
    @Test
    public void OneUserCantPlayGame() throws Exception {
        //give
        Game game = new Game();

        //when
        game.add("User1");

        //then
        assertFalse(game.isPlayable());
    }

    @Test
    public void TwoUserCanPlayGame() throws Exception {
        //give
        Game game = new Game();

        //when
        game.add("User1");
        game.add("User2");

        //then
        assertTrue(game.isPlayable());


    }
}
