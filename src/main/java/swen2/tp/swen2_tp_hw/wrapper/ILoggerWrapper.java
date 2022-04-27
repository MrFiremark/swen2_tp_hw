package swen2.tp.swen2_tp_hw.wrapper;

public interface ILoggerWrapper {

    void debug(String message);
    void warn(String message);
    void error(String message);
    void fatal(String message);

}
