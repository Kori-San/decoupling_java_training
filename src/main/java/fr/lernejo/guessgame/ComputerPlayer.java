package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    private final Logger _log = LoggerFactory.getLogger(ComputerPlayer.class.getName());

    private long max_age;
    private long min_age;
    private long prev;
    private boolean isGreater;

    public ComputerPlayer(long max){
        max_age = max;
        min_age = -1;
        isGreater = false;
    }

    @Override
    public long askNextGuess() {
        long proposition = -1;
        if(min_age == -1l){
            proposition = max_age/2;
            min_age = 0;
        }else{
            min_age = isGreater ? prev : min_age;
            max_age = !isGreater ? prev : max_age;
            proposition = (min_age+max_age)/2;
        }
        prev = proposition;
        _log.log("Computer propose "+proposition);
        return proposition;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        isGreater = lowerOrGreater;
        _log.log("Value "+prev+" is "+(lowerOrGreater?"greater":"lower"+" than guess"));
    }
}
