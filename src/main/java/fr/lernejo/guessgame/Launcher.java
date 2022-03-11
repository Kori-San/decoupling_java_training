package fr.lernejo.guessgame;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Launcher {

    public static void main(String[] args) {
        Simulation sim = null;
        if(args[0].equals("-interactive")){
            sim = new Simulation(new HumanPlayer());
            sim.initialize(new SecureRandom().nextInt(100));
            sim.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }else if(args[0].equals("-auto") && Pattern.compile("-?\\d+(\\.\\d+)?").matcher(args[1]).matches()){
            sim = new Simulation(new ComputerPlayer(Long.parseLong(args[1])));
            sim.initialize(new SecureRandom().nextLong(Long.parseLong(args[1])));
            sim.loopUntilPlayerSucceed(1000);
        }else{
            System.out.println("Pour lancer le mode interactive, taper -interactive.\n" +
                "Pour lancer le mode auto, taper -auto <max_value>");
        }
    }
}
