package ch01;

/**
 * 영화 비디오 정보
 */
public class Movie {

    public enum PriceCode {
        REGULAR {
            @Override
            public double calculate(Rental rental) {
                double amount = 2;
                if (rental.getDaysRented() > 2) {
                    amount += (rental.getDaysRented() - 2) * 1.5;
                }
                return amount;
            }
        },
        CHILDRENS {
            @Override
            public double calculate(Rental rental) {
                double amount = 1.5;
                if (rental.getDaysRented() > 3) {
                    amount += (rental.getDaysRented() - 3) * 1.5;
                }
                return amount;
            }
        },
        NEW_RELEASE {
            @Override
            public double calculate(Rental rental) {
                return rental.getDaysRented() * 3;
            }
        };

        public abstract double calculate(Rental rental);
    }

    private String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }
}
