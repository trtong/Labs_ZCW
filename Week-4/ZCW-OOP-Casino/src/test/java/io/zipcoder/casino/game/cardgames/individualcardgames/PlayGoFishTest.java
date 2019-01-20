package io.zipcoder.casino.game.cardgames.individualcardgames;

import io.zipcoder.casino.game.Player;

public class PlayGoFishTest {

    public static void main(String[] args) {
        Player player1 = new Player();
        GoFish gofishtest = new GoFish(player1);

        gofishtest.play();
    }



}
