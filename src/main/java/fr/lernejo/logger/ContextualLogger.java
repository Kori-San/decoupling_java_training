package fr.lernejo.logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private Logger delegateLogger;
    private String classname;

    public ContextualLogger(String classname, Logger children){
        delegateLogger = children;
        this.classname = classname;
    }
    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + classname + " " + message);
    }
}
