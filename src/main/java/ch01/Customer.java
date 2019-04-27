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
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        StringBuilder statementBuilder = new StringBuilder(String.format("%s 고객님의 대여 기록 \n", getName()));

        for (Rental rental : rentals) {
            double thisAmount;

            // 비디오 종류별 대여료 계산
            thisAmount = rental.getMovie().getPriceCode().calculate(rental);

            // 적립 포인트를 1 포인트 증가
            frequentRenterPoints++;

            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if (rental.getMovie().getPriceCode() == Movie.PriceCode.NEW_RELEASE
                    && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // 대여하는 비디오 정보와 대여료 출력
            statementBuilder.append(String.format("\t%s\t%s\n", rental.getMovie().getTitle(), String.valueOf(thisAmount)));

            totalAmount += thisAmount;
        }
        
        statementBuilder.append(String.format("누적 대여로: %s\n", String.valueOf(totalAmount)));
        statementBuilder.append(String.format("적립 포인트: %s", String.valueOf(frequentRenterPoints)));

        return statementBuilder.toString();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }
}
