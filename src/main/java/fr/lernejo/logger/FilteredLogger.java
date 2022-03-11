package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{
    private Logger logger;
    private Predicate<String> predicate;
    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        logger = delegate;
        predicate = condition;
    }

    @Override
    public void log(String message) {
        if(predicate.test(message)){
            logger.log(message);
        }
    }
}
