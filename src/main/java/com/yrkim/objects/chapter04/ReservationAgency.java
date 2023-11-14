package main.java.com.yrkim.objects.chapter04;

import main.java.com.yrkim.objects.chapter02.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();
        boolean discountable = false;

        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().isBefore(screening.getWhenScreened().toLocalTime()) &&
                        condition.getEndTime().isAfter(screening.getWhenScreened().toLocalTime());
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }

        Money fee;

        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT -> {
                    discountAmount = movie.getDiscountAmount();
                }
                case PERCENT_DISCOUNT -> {
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                }
                default -> throw new IllegalStateException("Unexpected value: " + movie.getMovieType());
            }
            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }
        return new Reservation(customer, screening, fee, audienceCount);
    }

    public Reservation reserve2(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
