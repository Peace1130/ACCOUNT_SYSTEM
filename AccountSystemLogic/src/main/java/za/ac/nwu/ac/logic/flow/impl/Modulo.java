package za.ac.nwu.ac.logic.flow.impl;

public class Modulo {
    public Integer doMod(int divident, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("Some Reason");
        }
        return divident % divisor;
    }
}
