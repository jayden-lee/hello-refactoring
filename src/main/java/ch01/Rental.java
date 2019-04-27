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

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
