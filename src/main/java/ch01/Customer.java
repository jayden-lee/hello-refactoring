package ch01;

import java.util.ArrayList;
import java.util.List;

/**
 * 고객 정보
 */
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList();

    public Customer(String name) {
        this.name = name;
    }

    /**
     * 고객이 대여한 내역을 생성해서 반환한다
     */
    public String statement() {
        int frequentRenterPoints = 0;

        StringBuilder resultStringBuilder = new StringBuilder(String.format("%s 고객님의 대여 기록 \n", getName()));

        for (Rental rental : rentals) {
            // 대여하는 비디오 정보와 대여료 출력
            resultStringBuilder.append(String.format("\t%s\t%s\n", rental.getMovie().getTitle(), String.valueOf(rental.getCharge())));
        }

        resultStringBuilder.append(String.format("누적 대여로: %s\n", String.valueOf(getTotalCharge())));
        resultStringBuilder.append(String.format("적립 포인트: %s", String.valueOf(getTotalFrequentRenterPoints())));

        return resultStringBuilder.toString();
    }

    public String htmlStatement() {
        StringBuilder resultStringBuilder = new StringBuilder(String.format("<H1><EM>%s 고객님의 대여 기록</EM></H1><P>\n", getName()));
        for (Rental rental : rentals) {
            resultStringBuilder.append(String.format("%s: %s<BR>\n", rental.getMovie().getTitle(), String.valueOf(rental.getCharge())));
        }

        resultStringBuilder.append(String.format("<P>누적 대여료: <EM>%s</EM></p>\n", String.valueOf(getTotalCharge())));
        resultStringBuilder.append(String.format("적립 포인트: <EM>%s</EM><P>", String.valueOf(getTotalFrequentRenterPoints())));

        return resultStringBuilder.toString();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {

            result += rental.getFrequentRenterPoints();

            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if (rental.getMovie().getPriceCode() == Movie.PriceCode.NEW_RELEASE
                    && rental.getDaysRented() > 1) {
                result++;
            }
        }

        return result;
    }

    public String getName() {
        return name;
    }
}
