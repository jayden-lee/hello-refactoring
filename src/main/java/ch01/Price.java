package ch01;

import static ch01.Movie.*;

public abstract class Price {

    public abstract PriceCode getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
