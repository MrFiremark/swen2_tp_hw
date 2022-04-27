package swen2.tp.swen2_tp_hw.wrapper;

public class UninitializedState extends LoggerBaseState{

    @Override
    public void debug(String message) {
        this.printUninitializedWarning();
        return;
    }

    @Override
    public void fatal(String message) {
        this.printUninitializedWarning();
        return;
    }

    @Override
    public void error(String message) {
        this.printUninitializedWarning();
        return;
    }

    @Override
    public void warn(String message) {
        this.printUninitializedWarning();
        return;
    }

    private void printUninitializedWarning() {
        System.out.println("Operation was called in state uninitialized.");
    }

}
