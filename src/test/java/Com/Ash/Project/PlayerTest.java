package Com.Ash.Project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;


import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player = new Player("");
    Game game = new Game();

    Random rand=new Random();





    @Test
    @DisplayName(" Testing damage")
    void damageTest() {

        // if u increase attributes such as strenght, level or agillity test will not be succesfull
        int damagedealt= rand.nextInt(1, player.fight());

        assertTrue(damagedealt>0,"Damages more then 0 " +damagedealt);
        assertTrue(damagedealt<20,"Damage is less then  20 "+damagedealt);



    }

    @Test
    @DisplayName("Testing if player can levelup")
    void testingLevelup() {

        player.setExp(40);
        assertEquals(2, player.playerLevelUpp());

    }

    //check gameover method in game class the logic of the test is there
    @Test
    @DisplayName(" Player can die and game ends")

    void playerLosingFightTest() {

        assertFalse(game.gameOver());

        }


        }















