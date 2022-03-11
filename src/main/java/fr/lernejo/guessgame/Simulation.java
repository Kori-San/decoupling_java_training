package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger(Simulation.class.getName());
    private Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long value = player.askNextGuess();
        if(value > numberToGuess){
            player.respond(false);
        }else if (value < numberToGuess){
            player.respond(true);
        }else{
            logger.log("The player found the number");
            return true;
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        while (!nextRound()){
        }
    }
    public void loopUntilPlayerSucceed(long count) {
        int cmp = 0;
        long start = System.currentTimeMillis();
        do{
            if(nextRound()){
                break;
            }
        }while(cmp++<=count);
        long end = System.currentTimeMillis();
        Date elapsed = new Date(end-start);
        DateFormat formatter = new SimpleDateFormat("mm:ss.SSS");

        if(cmp >= count){
            logger.log("The user has found the number guess in "+cmp+" loop and "+formatter.format(elapsed));
            System.out.println("You have found the number in "+formatter.format(elapsed));
        }else{
            logger.log("The user has not found the number guess in "+cmp+" loop and "+formatter.format(elapsed));
            System.out.println("You have not found the number in "+formatter.format(elapsed));
        }
    }
}
