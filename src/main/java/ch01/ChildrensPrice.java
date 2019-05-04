package ch01;

public class ChildrensPrice extends Price {

    @Override
    public Movie.PriceCode getPriceCode() {
        return Movie.PriceCode.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
