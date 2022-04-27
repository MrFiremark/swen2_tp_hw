package swen2.tp.swen2_tp_hw.wrapper;


public class LoggerFactory {
    public static ILoggerWrapper getLogger() {
        var logger = new Log4J2Wrapper();
        logger.initialize();
        return logger;
    }
}
