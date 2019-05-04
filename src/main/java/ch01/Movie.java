package ch01;

/**
 * 영화 비디오 정보
 */
public class Movie {

    public enum PriceCode {
        REGULAR,
        CHILDRENS,
        NEW_RELEASE
    }

    private String title;

    private Price price;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public PriceCode getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(PriceCode arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;

            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;

            default:
                throw new IllegalArgumentException("가격 코드가 잘못됐습니다.");
        }
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return  price.getFrequentRenterPoints(daysRented);
    }
}
