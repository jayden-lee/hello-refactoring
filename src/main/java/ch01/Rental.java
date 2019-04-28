package ch01;

/**
 * 대여 정보
 */
public class Rental {

    private Movie movie;
    private int daysRented; // 대여 기간

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    /**
     * 최신물을 이틀 이상 대여하면 보너스 포인트 지급
     */
    int getFrequentRenterPoints() {
        if (getMovie().getPriceCode() == Movie.PriceCode.NEW_RELEASE
                && getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public double getCharge() {
        return getMovie().getPriceCode().calculate(this);
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
