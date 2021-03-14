package javaInAction.partTwo.chapter5.dotSix;

import java.util.Objects;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-03-14
 * description
 */
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public static Transaction of(Trader trader, int year, int value) {
        Objects.requireNonNull(trader, "Transaction trader cannot be null");

        return new Transaction(trader, year, value);
    }

    private Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getYear() {
        return year;
    }

    public Trader getTrader() {
        return trader;
    }
}
